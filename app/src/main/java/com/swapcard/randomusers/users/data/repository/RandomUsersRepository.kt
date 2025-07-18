package com.swapcard.randomusers.users.data.repository

import com.swapcard.randomusers.users.data.network.api.dto.mapToDomainModel
import com.swapcard.randomusers.users.data.network.UsersApi
import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.data.storage.entity.mapToEntity
import com.swapcard.randomusers.users.data.storage.entity.mapToUser
import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import com.swapcard.randomusers.users.domain.util.DataError
import com.swapcard.randomusers.users.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RandomUsersRepository @Inject constructor(
    private val usersApi: UsersApi,
    private val userDao: UserDao,
    private val dispatcher: CoroutineDispatchProvider
) : UsersRepository {

    override suspend fun fetchUsers(
        page: Int,
        seed: String,
        count: Int
    ): Result<DomainUsers, DataError.Network> = withContext(dispatcher.io) {
        val response = usersApi.fetchUsers(
            page = page,
            seed = seed,
            count = count

        ).mapToDomainModel()
        Result.Success(response)
    }

    override suspend fun addUserToBookMark(user: User) {
        withContext(dispatcher.io) {
            userDao.addUser(user.mapToEntity())
        }
    }

    override suspend fun removeUserFromBookMark(user: User) {
        withContext(dispatcher.io) {
            userDao.deleteUser(user.mapToEntity())
        }
    }

    override fun getAllBookMarkedUsers(): Flow<List<User>> = userDao.getAllUsers()
        .map { emission ->
            emission.map { entity -> entity.mapToUser() }
        }

    override fun getBookMarkedUserById(userId: String): Flow<User> = flow {
        userDao.getUserById(userId)?.mapToUser()?.let {
            emit(it)
        }
    }


}

