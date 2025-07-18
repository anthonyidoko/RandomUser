package com.swapcard.randomusers.users.presentation.userlist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.swapcard.randomusers.users.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data object UserListRoute

fun NavGraphBuilder.userListScreen(
    onUserClick: (User) -> Unit
) {
    composable<UserListRoute> {
        UsersMainScreen(onUserClick = onUserClick)
    }
}
