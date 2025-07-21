package com.swapcard.randomusers.users.presentation.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.swapcard.randomusers.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomUsersTopBar(
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior,
    title: String
) {
    TopAppBar(
        modifier = modifier.testTag(stringResource(R.string.top_bar_test_tag)),
        title = {
            Text(
                modifier = Modifier.testTag(stringResource(R.string.top_bar_test_title)),
                text = title
            )
        },
        scrollBehavior = scrollBehavior,
        navigationIcon = {
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            scrolledContainerColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}