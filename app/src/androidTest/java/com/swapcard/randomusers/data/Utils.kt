package com.swapcard.randomusers.data

import com.swapcard.randomusers.users.presentation.detail.aUserWith

private val jake = aUserWith(firstName = "Jake", lastName = "Kambo").copy(
    isFavourite = false, country = "Germany", city = "Hamburger",
    streetName = "Unknown", gender = "female", phone = "091345678",
    cell = "0812345679", id = "1"
)
private val jimmy = aUserWith(firstName = "Jimmy", lastName = "Carta").copy(
    isFavourite = false, country = "Ghana", city = "Accra",
    streetName = "Unknown", gender = "male", phone = "0812345679",
    cell = "091345678", id = "2"
)
private val bryan = aUserWith(firstName = "Bryan", lastName = "Mambo").copy(
    isFavourite = false, country = "Canada", city = "Vancouvre",
    streetName = "Unknown", gender = "female", phone = "932-314-219",
    cell = "606-056-809", id = "3"
)

private val kelly = aUserWith(firstName = "Kelly", lastName = "Numbia").copy(
    isFavourite = false, country = "France", city = "Paris",
    streetName = "Unknown", gender = "female", phone = "932-314-219",
    cell = "606-056-809", id = "4"
)

private val hope = aUserWith(firstName = "Hope", lastName = "Chijuka").copy(
    isFavourite = false, country = "England", city = "Liverpool",
    streetName = "Unknown", gender = "female", phone = "932-314-210",
    cell = "606-056-810", id = "5"
)
private val onyi = aUserWith(firstName = "Onyeka", lastName = "Anthony").copy(
    isFavourite = false, country = "Spain", city = "Madrid",
    streetName = "Unknown", gender = "female", phone = "932-314-210",
    cell = "606-056-810", id = "6"
)
private val swap = aUserWith(firstName = "Swap", lastName = "Dreams").copy(
    isFavourite = false, country = "USA", city = "Newyork",
    streetName = "Unknown", gender = "male", phone = "932-314-210",
    cell = "606-056-810", id = "7"
)
val users = listOf(jake, swap, onyi, hope, kelly, bryan, jimmy)
