package com.swapcard.randomusers.users.data.network.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDobResponse(
    val age: Int?,
    val date: String?
)




