package com.swapcard.randomusers.users.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
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
    email: String?,
    isFavourite: Boolean = false,
    onUserClick: () -> Unit,
    onBookMarkClick: () -> Unit
) {
    Card(
        modifier = modifier
            .testTag(stringResource(R.string.user_item_card, firstName ?: ""))
            .clickable { onUserClick() }
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
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val colors = listOf(Color.White, Color.Black.copy(alpha = 0.8f), Color.White)
            UserCircularImage(
                modifier = Modifier
                    .drawWithContent {
                        drawContent()
                        drawCircle(
                            brush = Brush.radialGradient(
                                colors = colors,
                                tileMode = TileMode.Repeated,
                                center = Offset.Infinite,
                                radius = 200f
                            ),
                            style = Stroke(20f)
                        )
                    }
                    .widthIn(max = 100.dp)
                    .aspectRatio(1f)
                    .clip(CircleShape)
                    .padding(5.dp),
                url = imageUrl.orEmpty(),
                firstName = firstName.orEmpty()
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = "${firstName.orEmpty()} ${lastName.orEmpty()}",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = email.orEmpty(),
                    style = MaterialTheme.typography.bodySmall
                )
            }

            UserBookMark(
                onBookMarkClick = onBookMarkClick, isFavourite = isFavourite
            )

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
            email = "user@email.com",
            isFavourite = true,
            onUserClick = {},
            onBookMarkClick = {}
        )
    }
}