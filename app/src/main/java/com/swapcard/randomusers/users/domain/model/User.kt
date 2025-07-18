package com.swapcard.randomusers.users.domain.model

data class User(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val cell: String?,
    val dob: String?,
    val email: String?,
    val gender: String?,
    val phone: String?,
    val imageUrl: String?,
    val country: String?,
    val age: Int?,
    val isFavourite: Boolean = false,
    val state: String?,
    val city: String?,
    val streetName: String?,
    val streetNumber: Int?
)