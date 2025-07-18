package com.swapcard.randomusers.users.presentation.userlist.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.domain.model.User

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshLazyColumn(
    modifier: Modifier = Modifier,
    users: List<User>,
    isLoadMore: Boolean,
    isRefreshing: Boolean,
    listState: LazyListState = rememberLazyListState(),
    onUserClick: (String) -> Unit,
    onRefresh: () -> Unit
) {

    val pullToRefreshState = rememberPullToRefreshState()

    PullToRefreshBox(
        modifier = modifier,
        isRefreshing = isRefreshing,
        state = pullToRefreshState,
        onRefresh = onRefresh,
        contentAlignment = Alignment.Center
    ) {
            LazyColumn(
                modifier = modifier

                    .fillMaxSize(),
                state = listState,
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(users) { user ->
                    UserItemCard(
                        modifier = Modifier.clickable {
                            onUserClick(user.id)
                        },
                        firstName = user.firstName,
                        lastName = user.lastName,
                        imageUrl = user.imageUrl,
                        country = user.country,
                        age = user.age
                    )
                }

                if (isLoadMore) {
                    item {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                CircularProgressIndicator()
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    text = stringResource(R.string.loading_more),
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.labelMedium
                                )
                            }
                        }
                    }
                }
            }
    }

}


@Preview
@Composable
private fun UsersListPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        PullToRefreshLazyColumn(
            users = emptyList(),
            isLoadMore = false,
            isRefreshing = false,
            onRefresh = {},
            onUserClick = {}
        )
    }
}