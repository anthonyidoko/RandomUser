package com.swapcard.randomusers.users.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserNameResponse(
    val first: String?,
    val last: String?,
    val title: String?
)

fun UserNameResponse.firstName(): String?  = first
fun UserNameResponse.lastName(): String?  = last



