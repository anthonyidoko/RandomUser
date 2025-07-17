package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object UserDetailScreen

fun NavGraphBuilder.userDetailScreen(
    onBackButtonClick: () -> Unit
) {

    composable<UserDetailScreen> {
        UserDetailScreenRoot()
    }
}

@Composable
fun UserDetailScreenRoot() {

    Text(text = "Detail")
}

