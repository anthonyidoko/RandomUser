package com.swapcard.randomusers.users.domain.repository

import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.util.DataError
import com.swapcard.randomusers.users.domain.util.Result
import kotlinx.coroutines.flow.Flow

interface UsersRepository {
    suspend fun fetchUsers(
        page: Int,
        seed: String,
        count: Int
    ): Result<DomainUsers, DataError.Network>

    suspend fun addUserToBookMark(user: User)
    suspend fun removeUserFromBookMark(user: User)
    fun getAllBookMarkedUsers(): Flow<List<User>>
    fun getBookMarkedUserById(userId: String): Flow<User>
}

