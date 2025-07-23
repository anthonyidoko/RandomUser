package com.swapcard.randomusers.users.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil3.compose.rememberAsyncImagePainter
import com.swapcard.randomusers.R

@Composable
fun UserCircularImage(
    url: String,
    firstName: String,
    modifier: Modifier = Modifier,
) {

    Box(
        modifier = modifier,
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
                        .clip(RoundedCornerShape(100))
                        .fillMaxSize(),
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


@Preview
@Composable
private fun UserCircularImagePreview() {
    Surface {
        UserCircularImage("", "")
    }
}