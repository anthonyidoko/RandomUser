package com.swapcard.randomusers.users.data.repository

import com.swapcard.randomusers.users.data.dto.mapToDomainModel
import com.swapcard.randomusers.users.data.network.api.UsersApi
import com.swapcard.randomusers.users.data.storage.UserDao
import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.Result
import javax.inject.Inject


class RandomUsersRepository @Inject constructor(
    private val usersApi: UsersApi,
    private val userDao: UserDao
) : UsersRepository {

    override suspend fun fetchUsers(
        page: Int,
        seed: String,
        count: Int
    ): Result<DomainUsers> {
        val response = usersApi.fetchUsers(
            page = page,
            seed = seed,
            count = count

        ).mapToDomainModel()
        return Result.Success(response)
    }

    override suspend fun addUserToBookMark(userId: String) {
        TODO("Not yet implemented")
    }
}
