package com.swapcard.randomusers.users.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    val info: UsersResponseInfo?,
    val results: List<UserResponse>?,
    val error: String?
)

