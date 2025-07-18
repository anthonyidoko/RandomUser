package com.swapcard.randomusers.users.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.swapcard.randomusers.users.presentation.detail.navigateToUserDetailsListScreen
import com.swapcard.randomusers.users.presentation.detail.userDetailScreen
import com.swapcard.randomusers.users.presentation.userlist.UserListRoute
import com.swapcard.randomusers.users.presentation.userlist.userListScreen
import kotlinx.serialization.Serializable

@Serializable
data object UserNavigation

fun NavGraphBuilder.userNavigation(
    navController: NavHostController,
) {
    navigation<UserNavigation>(
        startDestination = UserListRoute
    ) {

        userListScreen(
            onUserClick = { user -> navController.navigateToUserDetailsListScreen(user)}
        )

        userDetailScreen(
            onBackButtonClick = {}
        )

    }
}


