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
        dob = dob?.mapToDomainModel(),
        email = email,
        gender = gender,
        id = id?.mapToDomainModel(),
        location = location?.mapToDomainModel(),
        name = name?.mapToDomainModel(),
        nat = nat,
        imageUre = picture?.large
    )
}




