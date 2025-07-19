package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.presentation.components.UserBookMark
import com.swapcard.randomusers.users.presentation.detail.component.BirthInformation
import com.swapcard.randomusers.users.presentation.detail.component.SectionInfo
import com.swapcard.randomusers.users.presentation.detail.component.SectionRow

@Composable
fun UserDetailScreen(
    user: User,
    onBookMarkClick: () -> Unit,
    onBackButtonClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize()
                .padding(20.dp)
        ) {

            UserRectangularImage(
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .aspectRatio(1f),
                url = user.imageUrl,
                firstName = user.firstName
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "${user.firstName.orEmpty()} ${user.lastName.orEmpty()}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                ),
                textAlign = TextAlign.Center
            )


            SectionInfo(
                headerTitle = stringResource(R.string.contact)
            ) {

                user.email?.let { email ->
                    SectionRow(
                        title = stringResource(R.string.email),
                        content = email
                    )
                }

                user.phone?.let { phone ->
                    SectionRow(
                        title = stringResource(R.string.phone),
                        content = phone
                    )
                }
                user.cell?.let { cell ->
                    SectionRow(
                        title = stringResource(R.string.cell),
                        content = cell
                    )
                }
            }

            SectionInfo(
                headerTitle = stringResource(R.string.location)
            ) {

                SectionRow(
                    title = stringResource(R.string.street),
                    content = "${user.streetNumber ?: ""} ${",".takeIf { user.streetNumber != null }} ${user.streetName.orEmpty()}"
                )

                user.city?.let { city ->
                    SectionRow(
                        title = stringResource(R.string.city),
                        content = city
                    )
                }
                user.state?.let { state ->
                    SectionRow(
                        title = stringResource(R.string.state),
                        content = state
                    )
                }
            }

            SectionInfo(
                headerTitle = stringResource(R.string.birth_information)
            ) {
                BirthInformation(
                    dob = user.dob,
                    age = user.age
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    UserBookMark(
                        isFavourite = user.isFavourite,
                        onBookMarkClick = onBookMarkClick
                    )

                    Text(
                        text = if (user.isFavourite) {
                            stringResource(R.string.remove_from_favourite)
                        } else {
                            stringResource(R.string.add_to_favourite)
                        }
                    )
                }
            }

        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {

            IconButton(onClick = onBackButtonClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back_button)
                )
            }
        }
    }

}


@Preview
@Composable
private fun UserDetailScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserDetailScreen(
            aUserWith(
                firstName = "Luz",
                lastName = "Pastor"
            ),
            onBookMarkClick = {},
            onBackButtonClick = {}
        )
    }
}


fun aUserWith(firstName: String, lastName: String): User {
    return User(
        firstName = firstName,
        lastName = lastName,
        state = "",
        isFavourite = true,
        age = 24,
        country = "Canada",
        streetNumber = 12,
        streetName = "Jakarta",
        gender = "Female",
        email = "firstname@email.com",
        dob = "",
        cell = "0901123333",
        id = "",
        phone = "",
        imageUrl = "",
        city = "Astapor"
    )
}