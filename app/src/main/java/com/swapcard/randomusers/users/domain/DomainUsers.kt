package com.swapcard.randomusers.users.domain

import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.model.UserInfo

data class DomainUsers(
    val info: UserInfo?,
    val results: List<User>?,
    val error: String?
)