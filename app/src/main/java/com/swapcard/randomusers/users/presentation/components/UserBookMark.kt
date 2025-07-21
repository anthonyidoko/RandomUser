package com.swapcard.randomusers.users.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import com.swapcard.randomusers.R

@Composable
fun UserBookMark(
    modifier: Modifier = Modifier,
    onBookMarkClick: () -> Unit, isFavourite: Boolean) {
    IconButton(
        modifier = modifier.testTag(stringResource(R.string.add_to_bookmarked_icon_test_tag)),
        onClick = onBookMarkClick) {
        Icon(
            imageVector = Icons.Default.Favorite.takeIf { isFavourite }
                ?: Icons.Default.FavoriteBorder,
            contentDescription = stringResource(
                R.string.add_to_favourite
            ).takeIf { isFavourite }
                ?: stringResource(R.string.remove_from_favourite),
            tint = if (isFavourite) Color.Red else MaterialTheme.colorScheme.onSurface
        )
    }
}