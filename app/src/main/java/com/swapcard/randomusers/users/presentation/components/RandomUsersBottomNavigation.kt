package com.swapcard.randomusers.users.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.presentation.bookmark.BookMarkedRoute
import com.swapcard.randomusers.users.presentation.userlist.UserListRoute

@Composable
fun RandomUsersBottomNavigation(
    modifier: Modifier = Modifier,
    hierarchy: Sequence<NavDestination>?,
    onNavigateToBookMarked: () -> Unit,
    onNavigateToHome: () -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        NavigationBarItem(
            selected = hierarchy?.any { it.hasRoute(UserListRoute::class) } == true,
            onClick = {
                onNavigateToHome()
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = stringResource(R.string.user_list_icon)
                )
            },
            label = {
                Text(text = stringResource(R.string.home))
            }
        )

        NavigationBarItem(
            selected = hierarchy?.any { it.hasRoute(BookMarkedRoute::class) } == true,
            onClick = {
                onNavigateToBookMarked()
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_bookmarks_24),
                    contentDescription = stringResource(R.string.bookmarked_icon)
                )
            },
            label = {
                Text(text = stringResource(R.string.bookmarked_label))
            }
        )

    }

}