package com.swapcard.randomusers.users.presentation.utils

import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.presentation.bookmark.BookMarkedRoute
import com.swapcard.randomusers.users.presentation.userlist.UserListRoute

fun NavDestination.getToAppBarTitleResId(): Int {
    return when {
        hasRoute<UserListRoute>() -> R.string.users
        hasRoute<BookMarkedRoute>() -> R.string.bookmarked_users
        else -> R.string.empty
    }
}