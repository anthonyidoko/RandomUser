package com.swapcard.randomusers.users.presentation.bookmark

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Serializable
data object BookMarkedRoute

fun NavGraphBuilder.bookMarkScreen() {
    composable<BookMarkedRoute> {
        BookMarkScreenRoot()
    }
}


fun NavHostController.navigateBookMarkScreen() {
    navigate(BookMarkedRoute) {
        popUpTo(graph.id)
    }
}