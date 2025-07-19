package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.swapcard.randomusers.users.presentation.utils.mapToDomainUser

@Composable
fun UserDetailScreenRoot(
    onBackButtonClick: () -> Unit
) {
    val viewModel: UserDetailViewModel = hiltViewModel()
    val userState by viewModel.state.collectAsStateWithLifecycle()
    val user = userState.mapToDomainUser()

    UserDetailScreen(
        user = user,
        onBookMarkClick = viewModel::onBookMarkClick,
        onBackButtonClick = onBackButtonClick
    )

}

