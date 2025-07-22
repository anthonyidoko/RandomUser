package com.swapcard.randomusers.users.presentation.userlist

import androidx.annotation.StringRes
import com.swapcard.randomusers.users.domain.model.User

data class UserListUiState(
    val isLoading: Boolean = false,
    val isLoadingMore: Boolean = false,
    val isError: Boolean = false,
    @StringRes val errorResId: Int? = null,
    val page: Int = 0,
    val seed: String = "9c951a4baedfb80e",
    val isRefreshing: Boolean = false,
    val bookMarkedUsers: List<User> = emptyList(),
    val users: List<User> = emptyList()
)
