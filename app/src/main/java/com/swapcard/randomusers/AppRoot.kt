package com.swapcard.randomusers

import androidx.compose.runtime.Composable
import com.swapcard.randomusers.ui.theme.RandomUsersTheme
import com.swapcard.randomusers.users.UsersMainScreen

@Composable
fun AppRoot() {
    RandomUsersTheme {
        UsersMainScreen()
    }
}

