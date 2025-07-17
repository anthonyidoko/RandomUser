package com.swapcard.randomusers.users.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation
import com.swapcard.randomusers.users.presentation.detail.navigateToUserDetailsListScreen
import com.swapcard.randomusers.users.presentation.detail.userDetailScreen
import com.swapcard.randomusers.users.presentation.userlist.UsersLise
import com.swapcard.randomusers.users.presentation.userlist.userListScreen
import kotlinx.serialization.Serializable

@Serializable
data object UserNavigation

fun NavGraphBuilder.userNavigation(
    navController: NavHostController,
) {
    navigation<UserNavigation>(
        startDestination = UsersLise
    ) {

        userListScreen(
            onUserClick = { navController.navigateToUserDetailsListScreen()}
        )

        userDetailScreen(
            onBackButtonClick = {}
        )

    }
}


