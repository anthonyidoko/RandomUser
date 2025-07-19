package com.swapcard.randomusers.users.presentation.userlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.swapcard.randomusers.users.domain.model.User


@Composable
fun UserListScreenRoot(onUserClick: (User) -> Unit) {

    val viewModel: UserListViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    UserListScreen(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        onUserClick = onUserClick,
        onLoadMoreUsers = viewModel::loadMoreUsers,
        onRefresh = viewModel::refreshUserList,
        onBookMarkClick = viewModel::onBookMarkClick
    )
}