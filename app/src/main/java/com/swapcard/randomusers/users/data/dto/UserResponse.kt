package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val cell: String?,
    val dob: UserDobResponse?,
    val email: String?,
    val gender: String?,
    val id: UserIdResponse?,
    val location: UserLocationResponse?,
    val name: UserNameResponse?,
    val nat: String?,
    val phone: String?,
    val picture: UserPictureResponse?
)

fun UserResponse.mapToDomainModel(): User {
    return User(
        cell = cell,
        phone = phone,
        dob = dob?.date,
        email = email,
        gender = gender,
        id = id?.mapToDomainModel().orEmpty(),
        location = location?.mapToDomainModel(),
        imageUrl = picture?.large,
        country = location?.country,
        firstName = name?.firstName(),
        lastName = name?.lastName(),
        age = dob?.age
    )
}




