package com.swapcard.randomusers.users.domain.usecase

import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import com.swapcard.randomusers.users.domain.util.DataError
import com.swapcard.randomusers.users.domain.util.Result
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetUsersUseCase(
    private val repository: UsersRepository,
    private val dispatchProvider: CoroutineDispatchProvider,
    private val combinator: UsersManager
) {

    operator fun invoke(
        page: Int,
        seed: String = "9c951a4baedfb80e",
        count: Int = 25
    ): Flow<Result<DomainUsers, DataError>> = flow<Result<DomainUsers, DataError>> {

            val bookMarked = coroutineScope {
                repository.getAllBookMarkedUsers().firstOrNull()
            }
            val usersResponse = coroutineScope {
                repository.fetchUsers(page = page, seed = seed, count = count)
            }

            when (usersResponse) {
                is Result.Success -> {
                    if (bookMarked != null) {
                        val combinedUsers = combinator.combine(
                            first = bookMarked,
                            second = usersResponse.data.results.orEmpty()
                        )
                        val domainUsers = DomainUsers(
                            info = usersResponse.data.info,
                            results = combinedUsers,
                            error = usersResponse.data.error
                        )
                        emit(Result.Success(domainUsers))
                    } else {
                        emit(usersResponse)
                    }
                }

                is Result.Failure -> {
                    if (bookMarked != null) {
                        val domainUsers = DomainUsers(
                            info = null,
                            results = bookMarked,
                            error = null
                        )
                        emit(Result.Success(domainUsers, usersResponse.error))
                    } else {
                        emit(usersResponse)
                    }

                }
            }
    }.flowOn(dispatchProvider.io)
}
