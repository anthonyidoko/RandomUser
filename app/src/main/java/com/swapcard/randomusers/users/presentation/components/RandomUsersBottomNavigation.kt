package com.swapcard.randomusers.users.presentation.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import kotlinx.serialization.Serializable

@Serializable
sealed class BottomDestination(
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int,
    @StringRes val label: Int,
    val route: String
) {
    @Serializable
    data object Home : BottomDestination(
        icon = R.drawable.baseline_home_24,
        contentDescription = R.string.user_list_icon,
        label = R.string.home,
        route = "Home"
    )

    @Serializable
    data object BookMarked : BottomDestination(
        icon = R.drawable.baseline_bookmarks_24,
        contentDescription = R.string.bookmarked_icon,
        label = R.string.bookmarked_label,
        route = "BookMark"
    )


    companion object {
        fun entries(): List<BottomDestination> {
            return listOf(
                Home,
                BookMarked
            )
        }
    }
}

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
                    painter = painterResource(BottomDestination.Home.icon),
                    contentDescription = stringResource(BottomDestination.Home.contentDescription)
                )
            },
            label = {
                Text(
                    text = stringResource(BottomDestination.Home.label)
                )
            }
        )

        NavigationBarItem(
            selected = hierarchy?.any { it.hasRoute(BookMarkedRoute::class) } == true,
            onClick = {
                onNavigateToBookMarked()
            },
            icon = {
                Icon(
                    painter = painterResource(BottomDestination.BookMarked.icon),
                    contentDescription = stringResource(BottomDestination.BookMarked.contentDescription)
                )
            },
            label = {
                Text(
                    text = stringResource(BottomDestination.BookMarked.label)
                )
            }
        )

    }

}