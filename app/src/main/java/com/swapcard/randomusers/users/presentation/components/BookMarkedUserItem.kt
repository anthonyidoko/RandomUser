package com.swapcard.randomusers.users.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.widthIn
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

        Card(
            modifier = modifier
                .sizeIn(maxWidth = 100.dp)
                .aspectRatio(1f)
                .clip(RoundedCornerShape(100)),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSurface
            )
        ) {

            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(100))
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                UserCircularImage(
                    modifier = Modifier
                        .widthIn(max = 180.dp)
                        .aspectRatio(1f)
                        .clip(RoundedCornerShape(100))
                        .background(color = MaterialTheme.colorScheme.primaryContainer)
                        .padding(5.dp),
                    url = imageUrl.orEmpty(),
                    firstName = firstName.orEmpty()
                )


            }
        }
        Text(text = firstName.orEmpty())
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