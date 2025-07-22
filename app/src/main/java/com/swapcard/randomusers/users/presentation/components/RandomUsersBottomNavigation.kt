package com.swapcard.randomusers.users.presentation.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
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
        modifier = modifier.testTag(stringResource(R.string.bottom_bar_test_tag)),
        windowInsets = NavigationBarDefaults.windowInsets
    ) {
        NavigationBarItem(
            modifier = Modifier.testTag(stringResource(R.string.home_navigation_item)),
            selected = hierarchy?.any { it.hasRoute(UserListRoute::class) } == true,
            onClick = {
                onNavigateToHome()
            },
            icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_home_24),
                    contentDescription = stringResource(R.string.home_icon)
                )
            },
            label = {
                Text(text = stringResource(R.string.home))
            }
        )

        NavigationBarItem(
            modifier = Modifier.testTag(stringResource(R.string.bookmark_navigation_item)),
            selected = hierarchy?.any { it.hasRoute(BookMarkedRoute::class) } == true,
            onClick = {
                onNavigateToBookMarked()
            },
            icon = {
                Icon(
                    modifier = Modifier.testTag(stringResource(R.string.bookmarked_icon)),
                    painter = painterResource(R.drawable.baseline_bookmarks_24),
                    contentDescription = stringResource(R.string.bookmarked_icon)
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bookmarked_label))
            }
        )

    }

}