package com.swapcard.randomusers.users.presentation.userlist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.userListScreen(
    onUserClick: () -> Unit
) {
    composable<UsersLise> {
        UserListScreenRoot(
            onUserClick = onUserClick
        )
    }
}