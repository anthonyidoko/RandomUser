package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.rememberAsyncImagePainter
import com.swapcard.randomusers.R

@Composable
fun UserRectangularImage(
    modifier: Modifier = Modifier,
    url: String?,
    firstName: String?
) {
    Card(
        modifier = modifier
            .fillMaxSize(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
        )
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            var imageResult by remember {
                mutableStateOf<Result<Painter>?>(null)
            }
            val imagePainter = rememberAsyncImagePainter(
                model = url,
                onSuccess = {
                    val size = it.painter.intrinsicSize
                    imageResult = if (size.width > 1 && size.height > 1) {
                        Result.success(it.painter)
                    } else {
                        Result.failure(Throwable())
                    }
                },
                onError = {
                    imageResult = Result.failure(it.result.throwable)
                },
            )



            when (val result = imageResult) {
                null -> {
                    CircularProgressIndicator()
                }

                else -> {
                    Image(
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(10)),
                        painter = if (result.isSuccess) {
                            imagePainter
                        } else {
                            painterResource(R.drawable.user)
                        }, contentDescription = firstName,
                        contentScale = ContentScale.Crop
                    )
                }

            }
        }
    }
}


@Preview
@Composable
private fun UserRectangularImagePreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserRectangularImage(
            url = "",
            firstName = ""
        )
    }
}