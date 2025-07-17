package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserDob
import kotlinx.serialization.Serializable

@Serializable
data class UserDobResponse(
    val age: Int?,
    val date: String?
)

fun UserDobResponse.mapToDomainModel(): UserDob = UserDob(age = age, date = date)




