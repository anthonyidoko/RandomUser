package com.swapcard.randomusers.users.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BookMarkedUserItem(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    firstName: String?
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val colors by remember {
            derivedStateOf { listOf(Color.Cyan, Color.Blue).shuffled() }
        }
        Card(
            modifier = modifier
                .drawWithContent {
                    drawContent()
                    drawCircle(
                        brush = Brush.radialGradient(
                            colors = colors,
                            tileMode = TileMode.Repeated,
                            center = Offset.Zero,
                        ),
                        style = Stroke(20f),
                    )
                }
                .clip(CircleShape)
                .sizeIn(maxWidth = 100.dp)
                .aspectRatio(1f)
        ) {

            Column(
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                UserCircularImage(
                    modifier = Modifier
                        .widthIn(max = 180.dp)
                        .aspectRatio(1f)
                        .clip(CircleShape)
                        .padding(5.dp),
                    url = imageUrl.orEmpty(),
                    firstName = firstName.orEmpty()
                )


            }
        }
        Spacer(modifier.height(5.dp))
        Text(
            text = firstName.orEmpty(),
            style = MaterialTheme.typography.titleMedium
        )
    }
}


@Preview
@Composable
private fun RowItemComPrev() {
    Surface(
    ) {
        BookMarkedUserItem(
            firstName = "FirstName",
            imageUrl = ""
        )
    }
}