package com.swapcard.randomusers.users.data.network.api

import com.swapcard.randomusers.users.data.dto.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {

    @GET("/api/")
    suspend fun fetchUsers(
        @Query("results") count: Int,
        @Query("page") page: Int,
        @Query("seed") seed: String
    ): UsersResponse
}
