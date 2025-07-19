package com.swapcard.randomusers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.swapcard.randomusers.ui.theme.RandomUsersTheme
import com.swapcard.randomusers.users.presentation.detail.navigateToUserDetailsListScreen
import com.swapcard.randomusers.users.presentation.detail.detailScreen
import com.swapcard.randomusers.users.presentation.userlist.UserListRoute
import com.swapcard.randomusers.users.presentation.userlist.mainScreen

@Composable
fun AppRoot() {
    RandomUsersTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = UserListRoute,
        ) {

            mainScreen(
                onUserClick = {
                    user -> navController.navigateToUserDetailsListScreen(user) }
            )

            detailScreen(
                onBackButtonClick = {
                    navController.navigateUp()
                }
            )
        }
    }
}

