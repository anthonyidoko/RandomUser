package com.swapcard.randomusers.users.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.R

@Composable
fun UserItemCard(
    modifier: Modifier = Modifier,
    firstName: String?,
    lastName: String?,
    imageUrl: String?,
    country: String?,
    isFavourite: Boolean = false,
    age: Int?,
    onBookMarkClick: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clip(RoundedCornerShape(12)),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = modifier
                .clip(RoundedCornerShape(12))
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            UserCircularImage(
                modifier = Modifier
                    .widthIn(max = 100.dp)
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(100))
                    .background(color = MaterialTheme.colorScheme.onSecondary)
                    .padding(5.dp),
                url = imageUrl.orEmpty(),
                firstName = firstName.orEmpty()
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterVertically
                ),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "${firstName.orEmpty()} ${lastName.orEmpty()}"
                )
                Text(
                    text = country.orEmpty()
                )

                Text(
                    text = "$age years".takeIf { age != null }.orEmpty()
                )
            }

            IconButton(onClick = onBookMarkClick) {
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
    }
}

@Preview
@Composable
private fun UserItemCardPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserItemCard(
            firstName = "OnyekaChukwu",
            lastName = "Anthony Idoko",
            imageUrl = "",
            country = "Nigeria",
            isFavourite = true,
            age = 10,
            onBookMarkClick = {}
        )
    }
}