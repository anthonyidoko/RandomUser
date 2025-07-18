package com.swapcard.randomusers.users.domain.repository

import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.util.Result

interface UsersRepository {
    suspend fun fetchUsers(
        page: Int,
        seed: String = "9c951a4baedfb80e",
        count: Int = 25
    ): Result<DomainUsers>
}

