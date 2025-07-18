package com.swapcard.randomusers.users.domain.model

data class User(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val cell: String?,
    val dob: String?,
    val email: String?,
    val gender: String?,
    val location: UserLocation?,
    val phone: String?,
    val imageUrl: String?,
    val country: String?,
    val age: Int?,
    val isFavourite: Boolean = false
)