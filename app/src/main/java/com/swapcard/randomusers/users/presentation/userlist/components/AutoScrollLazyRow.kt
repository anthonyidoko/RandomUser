package com.swapcard.randomusers.users.presentation.userlist.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.users.presentation.components.BookMarkedUserItem
import com.swapcard.randomusers.users.presentation.userlist.UserListUiState

@Composable
fun AutoScrollLazyRow(
    modifier: Modifier = Modifier,
    state: UserListUiState
) {
    val listState = rememberLazyListState()
    LaunchedEffect(state.bookMarkedUsers.size) {
        if (state.bookMarkedUsers.isNotEmpty()) {
            listState.animateScrollToItem(state.bookMarkedUsers.lastIndex, 0)
        }
    }

    Card(
        modifier = modifier,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        LazyRow(
            state = listState,
            contentPadding = PaddingValues(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Hello There")
                }
            }
            items(state.bookMarkedUsers) { user ->
                BookMarkedUserItem(
                    imageUrl = user.imageUrl,
                    firstName = user.firstName
                )
            }
        }
    }

}