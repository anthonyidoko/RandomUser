package com.swapcard.randomusers.users.presentation.bookmark

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.components.UserItemCard

@Composable
fun BookMarkScreen(
    modifier: Modifier = Modifier,
    state: BookMarkUiState,
    onUserClick: (User) -> Unit,
    onBookMarkClick: (User) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        if (state.users.isEmpty()) {
            item {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.TopCenter
                ) {
                    Text(text = stringResource(R.string.no_bookmarked_users))
                }
            }
        }
        items(state.users) { user ->
            UserItemCard(
                firstName = user.firstName,
                lastName = user.lastName,
                imageUrl = user.imageUrl,
                email = user.email,
                isFavourite = user.isFavourite,
                onUserClick = { onUserClick(user) },
                onBookMarkClick = { onBookMarkClick(user) }
            )
        }
    }
}