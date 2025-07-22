package com.swapcard.randomusers.data

import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.data.storage.entity.mapToEntity
import com.swapcard.randomusers.users.data.storage.entity.mapToUser
import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.DataError
import com.swapcard.randomusers.users.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class TestUserRepository(
    private val userDao: UserDao
) : UsersRepository {
    private val userResponse = DomainUsers(
        results = users,
        info = null,
        error = null
    )

    override suspend fun fetchUsers(
        page: Int,
        seed: String,
        count: Int
    ): Result<DomainUsers, DataError.Network> {
        return Result.Success(userResponse)
    }

    override suspend fun addUserToBookMark(user: User) {
        userDao.addUser(user.mapToEntity())
    }

    override suspend fun removeUserFromBookMark(user: User) {
        userDao.deleteUser(user.mapToEntity())
    }

    override fun getAllBookMarkedUsers(): Flow<List<User>> = userDao.getAllUsers()
        .map { emission ->
            emission.map { entity ->
                entity.mapToUser()
            }
        }

    override fun getBookMarkedUserById(userId: String): Flow<User> = flow {
        userDao.getUserById(userId)?.mapToUser()?.let {
            emit(it)
        }
    }

}
