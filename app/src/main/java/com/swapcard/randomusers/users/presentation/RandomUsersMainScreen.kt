package com.swapcard.randomusers.users.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.bookmark.bookMarkScreen
import com.swapcard.randomusers.users.presentation.bookmark.navigateBookMarkScreen
import com.swapcard.randomusers.users.presentation.components.RandomUsersBottomNavigation
import com.swapcard.randomusers.users.presentation.components.RandomUsersTopBar
import com.swapcard.randomusers.users.presentation.userlist.UserListRoute
import com.swapcard.randomusers.users.presentation.userlist.navigateUserListScreen
import com.swapcard.randomusers.users.presentation.userlist.userListScreen
import com.swapcard.randomusers.users.presentation.utils.getToAppBarTitleResId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RandomUsersMainScreen(
    onUserClick: (User) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    val navController = rememberNavController()
    var topBarUiText by remember {
        mutableIntStateOf(R.string.users)
    }
    navController.addOnDestinationChangedListener { _, destination, _ ->
        topBarUiText = destination.getToAppBarTitleResId()
    }

    Scaffold(
        topBar = {
            RandomUsersTopBar(
                title = stringResource(topBarUiText),
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            RandomUsersBottomNavigation(
                hierarchy = navController.currentBackStackEntryAsState().value
                    ?.destination?.hierarchy,
                onNavigateToBookMarked = { navController.navigateBookMarkScreen() },
                onNavigateToHome = { navController.navigateUserListScreen() }
            )
        }
    ) { innerPadding ->

        NavHost(
            modifier = Modifier
                .padding(innerPadding)
                .nestedScroll(scrollBehavior.nestedScrollConnection),
            navController = navController,
            startDestination = UserListRoute
        ) {
            userListScreen(onUserClick = onUserClick)

            bookMarkScreen(onUserClick = onUserClick)
        }

    }

}