package com.swapcard.randomusers.users.domain.model

data class UserLocation(
    val city: String?,
    val coordinates: UserCoordinates?,
    val country: String?,
    val postcode: String?,
    val state: String?,
    val timezone: UserTimezone?,
    val street: UserStreet?
)