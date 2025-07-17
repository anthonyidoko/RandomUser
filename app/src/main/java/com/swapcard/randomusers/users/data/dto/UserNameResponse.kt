package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserName
import kotlinx.serialization.Serializable

@Serializable
data class UserNameResponse(
    val first: String?,
    val last: String?,
    val title: String?
)

fun UserNameResponse.mapToDomainModel(): UserName {
    return UserName(
        first = first,
        last = last,
        title = title
    )
}

