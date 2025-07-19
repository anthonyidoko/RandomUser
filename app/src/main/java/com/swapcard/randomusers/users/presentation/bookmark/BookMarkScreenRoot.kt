package com.swapcard.randomusers.users.presentation.bookmark

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.swapcard.randomusers.users.domain.model.User

@Composable
fun BookMarkScreenRoot(onUserClick: (User) -> Unit) {

    val viewModel: BookMarkViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookMarkScreen(
        state = state,
        onUserClick = onUserClick,
        onBookMarkClick = viewModel::onBookMarkClick
    )

}

