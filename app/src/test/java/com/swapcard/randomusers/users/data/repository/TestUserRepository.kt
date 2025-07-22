package com.swapcard.randomusers.users.data.repository

import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.DataError
import com.swapcard.randomusers.users.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TestUserRepository(
    private val userResponse: DomainUsers? = null
) : UsersRepository {
    private val localUsers = mutableListOf<User>()
    override suspend fun fetchUsers(
        page: Int,
        seed: String,
        count: Int
    ): Result<DomainUsers, DataError.Network> {
        return if (userResponse == null) {
            Result.Failure(DataError.Network.ServerError)
        } else {
            Result.Success(userResponse)
        }

    }

    override suspend fun addUserToBookMark(user: User) {
        localUsers.add(user)
    }

    override suspend fun removeUserFromBookMark(user: User) {
        localUsers.remove(user)
    }

    override fun getAllBookMarkedUsers(): Flow<List<User>> = flow {
        emit(localUsers)
    }

    override fun getBookMarkedUserById(userId: String): Flow<User> = flow {
        localUsers.find { it.id == userId }?.let { user ->
            emit(user)
        }
    }


}
