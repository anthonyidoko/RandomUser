package com.swapcard.randomusers.users.presentation.userlist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object UserListRoute

fun NavGraphBuilder.userListScreen(
    onUserClick: () -> Unit
) {
    composable<UserListRoute> {
        UserListScreenRoot(
            onUserClick = onUserClick
        )
    }
}
