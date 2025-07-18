package com.swapcard.randomusers.users.data.network.api.dto

import com.swapcard.randomusers.users.domain.model.UserInfo
import kotlinx.serialization.Serializable

@Serializable
data class UsersResponseInfo(
    val page: Int?,
    val results: Int?,
    val seed: String?,
    val version: String?
)

fun UsersResponseInfo.mapToDomainModel(): UserInfo {
    return UserInfo(
        page = page,
        results = results,
        seed = seed
    )
}