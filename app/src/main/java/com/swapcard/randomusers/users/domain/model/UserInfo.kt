package com.swapcard.randomusers.users.domain.model

data class UserInfo(
    val page: Int?,
    val results: Int? = 25,
    val seed: String?
)