package com.swapcard.randomusers.users.presentation.userlist

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.RandomUsersMainScreen
import kotlinx.serialization.Serializable

@Serializable
data object UserListRoute

fun NavGraphBuilder.mainScreen(
    onUserClick: (User) -> Unit
) {
    composable<UserListRoute> {
        RandomUsersMainScreen(onUserClick = onUserClick)
    }
}
