package com.swapcard.randomusers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.swapcard.randomusers.ui.theme.RandomUsersTheme
import com.swapcard.randomusers.users.presentation.UserNavigation
import com.swapcard.randomusers.users.presentation.userNavigation

@Composable
fun AppRoot() {
    RandomUsersTheme {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = UserNavigation,
        ) {
            userNavigation(navController)
        }
    }
}

