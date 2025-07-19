package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun UserDetailScreenRoot(
    onBackButtonClick: () -> Unit
) {
    val viewModel: UserDetailViewModel = hiltViewModel()
    val state = viewModel.state
    UserDetailScreen(
        user = state,
        onBookMarkClick = viewModel::onBookMarkClick,
        onBackButtonClick = {
            viewModel.clearUser()
            onBackButtonClick()
        }
    )

}

