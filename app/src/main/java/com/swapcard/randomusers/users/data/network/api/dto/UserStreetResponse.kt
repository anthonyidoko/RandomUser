package com.swapcard.randomusers.users.data.network.api.dto

import com.swapcard.randomusers.users.domain.model.UserStreet
import kotlinx.serialization.Serializable

@Serializable
data class UserStreetResponse(
    val number: Int?,
    val name: String?
)

fun UserStreetResponse.mapToDomainModel(): UserStreet {
    return UserStreet(
        name = name,
        number = number
    )
}
