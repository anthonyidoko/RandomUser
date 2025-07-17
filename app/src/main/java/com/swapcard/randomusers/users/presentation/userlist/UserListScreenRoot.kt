package com.swapcard.randomusers.users.presentation.userlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapcard.randomusers.users.presentation.UserListViewModel

@Composable
fun UserListScreenRoot(
    onUserClick: () -> Unit
) {
    Scaffold { innerPadding ->
        val viewModel: UserListViewModel = hiltViewModel()

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {

            Text(
                modifier = Modifier.clickable { onUserClick() },
                text = "Hello Users",
            )
        }

    }

}