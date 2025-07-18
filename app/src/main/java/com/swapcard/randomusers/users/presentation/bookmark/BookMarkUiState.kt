package com.swapcard.randomusers.users.presentation.bookmark

import com.swapcard.randomusers.users.domain.model.User

data class BookMarkUiState(
    val users: List<User> = emptyList()
)
