package com.swapcard.randomusers.users.presentation.userlist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.userlist.components.PullToRefreshLazyColumn
import com.swapcard.randomusers.users.presentation.utils.Pagination.isCloseToEnd

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    state: UserListUiState,
    onUserClick: (String) -> Unit,
    onLoadMoreUsers: () -> Unit,
    onRefresh: () -> Unit,
    onBookMarkClick: (String) -> Unit = {}
) {

    val listState = rememberLazyListState()
    val closeToBottom by remember {
        derivedStateOf { listState.isCloseToEnd(1) }
    }

    LaunchedEffect(closeToBottom) {
        if (closeToBottom) onLoadMoreUsers()
    }

    Column(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(state.isLoading) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        PullToRefreshLazyColumn(
            modifier = Modifier,
            users = state.users,
            isLoadMore = state.isLoadingMore,
            listState = listState,
            onUserClick = onUserClick,
            onRefresh = onRefresh,
            isRefreshing = state.isRefreshing,
            onBookMarkClick = onBookMarkClick
        )
    }
}


@Preview
@Composable
private fun UserListScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        UserListScreen(
            state = UserListUiState(
                users = users,
                isLoadingMore = true
            ),

            onUserClick = {},
            onLoadMoreUsers = {},
            onRefresh = {}
        )
    }
}

private val users = (1..10).map {
    User(
        firstName = "User $it",
        lastName = "LastName $it",
        id = "$it",
        cell = "234567899",
        dob = "",
        email = "",
        gender = "f",
        country = "Nogeroa",
        phone = null,
        imageUrl = null,
        age = 23,
        city = null,
        state = "",
        streetName = "",
        streetNumber = 9
    )
}

