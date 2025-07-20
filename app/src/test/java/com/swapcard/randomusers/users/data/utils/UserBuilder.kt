package com.swapcard.randomusers.users.data.utils

import com.swapcard.randomusers.users.domain.DomainUsers
import com.swapcard.randomusers.users.domain.model.User

private fun buildUser(firstName: String): User {
    val unimportant = "::unimportant::"
    return User(
        firstName = firstName,
        lastName = unimportant,
        gender = unimportant,
        state = unimportant,
        city = unimportant,
        isFavourite = false,
        country = unimportant,
        imageUrl = unimportant,
        phone = unimportant,
        email = unimportant,
        dob = unimportant,
        cell = unimportant,
        streetNumber = 1,
        streetName = unimportant,
        age = 12,
        id = unimportant
    )
}

fun aUserWith(firstName: String): User{
    return buildUser(firstName)
}

fun domainUserWith(users: List<User>): DomainUsers{
    return DomainUsers(
        results = users,
        info = null,
        error = null
    )
}