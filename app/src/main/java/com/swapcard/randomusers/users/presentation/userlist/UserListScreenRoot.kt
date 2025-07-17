package com.swapcard.randomusers.users.presentation.userlist

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.presentation.UserListViewModel
import com.swapcard.randomusers.users.presentation.components.RandomUsersTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreenRoot(
    onUserClick: () -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            RandomUsersTopBar(
                title = stringResource(R.string.users),
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        val viewModel: UserListViewModel = hiltViewModel()
        val state by viewModel.state.collectAsStateWithLifecycle()

        UserListScreen(
            modifier = Modifier
                .padding(innerPadding)
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .fillMaxSize(),
            state = state,
            onUserClick = onUserClick
        )
    }

}

