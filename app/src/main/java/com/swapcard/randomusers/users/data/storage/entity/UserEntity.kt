package com.swapcard.randomusers.users.data.storage.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.swapcard.randomusers.users.domain.model.User

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val userId: String,
    val firstName: String?,
    val lastName: String?,
    val age: Int?,
    val dateOfBirth: String?,
    val country: String?,
    val gender: String?,
    val phone: String?,
    val imageUrl: String?,
    val isFavourite: Boolean = true,
    val city: String?,
    val state: String?,
    val streetNumber: Int?,
    val streetName: String?,
    val email: String?,
    val cell: String?
)


fun User.mapToEntity(): UserEntity {
    return UserEntity(
        userId = id,
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        age = age ?: 0,
        dateOfBirth = dob,
        country = country,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        city = city,
        state = state,
        streetNumber = streetNumber,
        streetName = streetName,
        email = email,
        cell = cell
    )
}

fun UserEntity.mapToUser(): User{
    return User(
        id = userId,
        firstName = firstName,
        lastName = lastName,
        cell = cell,
        dob = dateOfBirth,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        country = country,
        age = age,
        isFavourite = isFavourite,
        city = city,
        streetName = streetName,
        streetNumber = streetNumber,
        state = state,
        email = email
    )
}

