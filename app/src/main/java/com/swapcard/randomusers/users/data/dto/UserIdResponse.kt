package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserId
import kotlinx.serialization.Serializable

@Serializable
data class UserIdResponse(
    val name: String,
    val value: String
)


fun UserIdResponse.mapToDomainModel(): UserId {
    return UserId(
        name = name,
        value = value
    )
}

