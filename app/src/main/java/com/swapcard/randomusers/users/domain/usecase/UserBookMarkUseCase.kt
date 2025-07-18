package com.swapcard.randomusers.users.domain.usecase

import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.withContext

class UserBookMarkUseCase(
    private val repository: UsersRepository,
    private val dispatchProvider: CoroutineDispatchProvider
) {

    suspend operator fun invoke(user: User) {
        withContext(dispatchProvider.io) {
            val bookMarkedUser = repository.getBookMarkedUserById(user.id).firstOrNull()
            if (bookMarkedUser == null){
                repository.addUserToBookMark(user)
            }else{
                repository.removeUserFromBookMark(user)
            }
        }
    }
}