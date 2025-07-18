package com.swapcard.randomusers.users.data.network.api.dto

import com.swapcard.randomusers.users.domain.DomainUsers
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponse(
    val info: UsersResponseInfo? = null,
    val results: List<UserResponse>? = null,
    val error: String? = null
)

fun UsersResponse.mapToDomainModel(): DomainUsers {
    return DomainUsers(
        info = info?.mapToDomainModel(),
        results = results?.map { it.mapToDomainModel() },
        error = error
    )
}

