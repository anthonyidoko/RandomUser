package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserLocation
import kotlinx.serialization.Serializable

@Serializable
data class UserLocationResponse(
    val city: String?,
    val coordinates: UserCoordinatesResponse?,
    val country: String?,
    val state: String?,
    val timezone: UserTimezoneResponse?,
    val street: UserStreetResponse?
)


fun UserLocationResponse.mapToDomainModel(): UserLocation {
    return UserLocation(
        city = city,
        coordinates = coordinates?.mapToDomainModel(),
        country = country,
        state = state,
        timezone = timezone?.mapToDomainModel(),
        street = street?.mapToDomainModel()
    )
}


