package com.swapcard.randomusers.users.presentation.userlist

import com.swapcard.randomusers.users.domain.model.User

data class UserListUiState(
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val page: Int = 0,
    val seed: String = "",
    val isRefreshing: Boolean = false,
    val users: List<User> = emptyList()
)
