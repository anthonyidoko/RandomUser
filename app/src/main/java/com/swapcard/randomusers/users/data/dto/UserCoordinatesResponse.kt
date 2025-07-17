package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserCoordinates
import kotlinx.serialization.Serializable

@Serializable
data class UserCoordinatesResponse(
    val latitude: String?,
    val longitude: String?
)


fun UserCoordinatesResponse.mapToDomainModel(): UserCoordinates {
    return UserCoordinates(
        latitude = latitude,
        longitude = longitude
    )
}
