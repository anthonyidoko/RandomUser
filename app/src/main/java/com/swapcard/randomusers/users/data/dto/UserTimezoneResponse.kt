package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserTimezone
import kotlinx.serialization.Serializable

@Serializable
data class UserTimezoneResponse(
    val description: String?,
    val offset: String?
)


fun UserTimezoneResponse.mapToDomainModel(): UserTimezone {
    return UserTimezone(
        description = description,
        offset = offset
    )
}