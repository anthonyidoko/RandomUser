package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data class UserDetailRoute(val userId: String)

fun NavHostController.navigateToUserDetailsListScreen(userId: String) {
    navigate(UserDetailRoute(userId))
}

fun NavGraphBuilder.userDetailScreen(
    onBackButtonClick: () -> Unit
) {

    composable<UserDetailRoute> {
        UserDetailScreenRoot(
            onBackButtonClick = onBackButtonClick
        )
    }
}

@Composable
fun UserDetailScreenRoot(
    onBackButtonClick: () -> Unit
) {

    Text(text = "Detail")
}

