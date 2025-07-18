package com.swapcard.randomusers.users.data.network.api.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserIdResponse(
    val name: String?,
    val value: String?
)


fun UserIdResponse.mapToDomainModel(): String = "${name.orEmpty()}>${value.orEmpty()}"



