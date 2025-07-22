package com.swapcard.randomusers.users.presentation.utils

import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.detail.UserDetailRoute

fun User.mapToDomainUser(): UserDetailRoute {
    return UserDetailRoute(
        id = id,
        firstName = firstName,
        lastName = lastName,
        cell = cell,
        dob = dob,
        email = email,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        country = country,
        age = age,
        isFavourite = isFavourite,
        state = state,
        city = city,
        streetName = streetName,
        streetNumber = streetNumber
    )
}

fun UserDetailRoute.mapToDomainUser(): User {
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        cell = cell,
        dob = dob,
        email = email,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        country = country,
        age = age,
        isFavourite = isFavourite,
        state = state,
        city = city,
        streetName = streetName,
        streetNumber = streetNumber
    )
}