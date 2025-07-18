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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.components.UserItemCard
import kotlin.reflect.KFunction1

@Composable
fun BookMarkScreenRoot() {
    val viewModel: BookMarkViewModel = hiltViewModel()
    val state by viewModel.state.collectAsStateWithLifecycle()

    BookMarkScreen(
        modifier = Modifier
            .fillMaxSize(),
        state = state,
        onBookMarkClick = viewModel::onBookMarkClick
    )

}

@Composable
fun BookMarkScreen(
    modifier: Modifier,
    state: BookMarkUiState,
    onBookMarkClick: KFunction1<User, Unit>
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
                ){
                    Text(text = stringResource(R.string.no_bookmarked_users))
                }
            }
        }
        items(state.users) { user ->
            UserItemCard(
                firstName = user.firstName,
                lastName = user.lastName,
                imageUrl = user.imageUrl,
                country = user.country,
                isFavourite = user.isFavourite,
                age = user.age,
                onBookMarkClick = { onBookMarkClick(user) }
            )
        }
    }
}
