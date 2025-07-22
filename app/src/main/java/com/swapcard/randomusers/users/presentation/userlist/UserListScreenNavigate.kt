package com.swapcard.randomusers.users.presentation.userlist

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.swapcard.randomusers.users.domain.model.User


fun NavGraphBuilder.userListScreen(onUserClick: (User) -> Unit) {
    composable<UserListRoute> {
        UserListScreenRoot(
            onUserClick = onUserClick
        )
    }
}


fun NavController.navigateUserListScreen() {
    navigate(UserListRoute) {
        popUpTo(graph.id)
    }
}