package com.swapcard.randomusers.users.data.network

import com.swapcard.randomusers.users.data.network.api.dto.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UsersApi {

    @GET("/api/?exc=login,registered")
    suspend fun fetchUsers(
        @Query("results") count: Int,
        @Query("page") page: Int,
        @Query("seed") seed: String
    ): UsersResponse
}
