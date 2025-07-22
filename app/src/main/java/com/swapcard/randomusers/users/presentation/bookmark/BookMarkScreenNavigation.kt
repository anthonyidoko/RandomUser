package com.swapcard.randomusers.users.presentation.bookmark

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.swapcard.randomusers.users.domain.model.User
import kotlinx.serialization.Serializable


@Serializable
data object BookMarkedRoute

fun NavGraphBuilder.bookMarkScreen(onUserClick: (User) -> Unit) {
    composable<BookMarkedRoute> {
        BookMarkScreenRoot(onUserClick = onUserClick)
    }
}


fun NavHostController.navigateBookMarkScreen() {
    navigate(BookMarkedRoute) {
        popUpTo(graph.id)
    }
}