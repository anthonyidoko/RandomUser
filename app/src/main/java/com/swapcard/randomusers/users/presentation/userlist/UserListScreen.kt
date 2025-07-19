package com.swapcard.randomusers.users.presentation.userlist

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.components.UserCircularImage
import com.swapcard.randomusers.users.presentation.userlist.components.PullToRefreshLazyColumn
import com.swapcard.randomusers.users.presentation.utils.Pagination.isCloseToEnd

@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    state: UserListUiState,
    onUserClick: (User) -> Unit,
    onLoadMoreUsers: () -> Unit,
    onRefresh: () -> Unit,
    onBookMarkClick: (User) -> Unit = {}
) {

    val listState = rememberLazyListState()
    val closeToBottom by remember {
        derivedStateOf { listState.isCloseToEnd() }
    }

    LaunchedEffect(closeToBottom) {
        if (closeToBottom) onLoadMoreUsers()
    }



    Column(modifier = modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            AutoScrollLazyRow(state)
        }

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

@Composable
private fun AutoScrollLazyRow(state: UserListUiState) {
    val listState = rememberLazyListState()
    LaunchedEffect(state.bookMarkedUsers.size) {
        if (state.bookMarkedUsers.isNotEmpty()) {
            listState.animateScrollToItem(state.bookMarkedUsers.lastIndex, 0)
        }
    }

    LazyRow(
        state = listState,
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(state.bookMarkedUsers) { user ->
            BookMarkedUserItem(
                imageUrl = user.imageUrl,
                firstName = user.firstName
            )
        }
    }
}

@Composable
fun BookMarkedUserItem(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    firstName: String?
) {
    Card(
        modifier = modifier
            .sizeIn(maxWidth = 100.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(100)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(100))
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            UserCircularImage(
                modifier = Modifier
                    .widthIn(max = 180.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(100))
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .padding(5.dp),
                url = imageUrl.orEmpty(),
                firstName = firstName.orEmpty()
            )

        }
    }
}

@Preview
@Composable
fun RowItemComPrev() {
    Surface(
    ) {
        BookMarkedUserItem(
            firstName = users.first().firstName.orEmpty(),
            imageUrl = ""
        )
    }
}

@Preview
@Composable
private fun UserListScreenPreview() {
//    Surface(
//        modifier = Modifier.fillMaxSize()
//    ) {
//        UserListScreen(
//            state = UserListUiState(
//                users = users,
//                isLoadingMore = true
//            ),
//
//            onUserClick = {},
//            onLoadMoreUsers = {},
//            onRefresh = {}
//        )
//    }
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

