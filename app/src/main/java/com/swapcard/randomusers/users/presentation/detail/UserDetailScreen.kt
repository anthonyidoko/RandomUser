package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.swapcard.randomusers.users.domain.model.User

@Composable
fun UserDetailScreen(state: User) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize()
            .padding(20.dp)
    ) {

        UserRectangularImage(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .aspectRatio(1f),
            url = state.imageUrl,
            firstName = state.firstName
        )

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "${state.firstName.orEmpty()} ${state.lastName.orEmpty()}",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}


@Preview
@Composable
private fun UserDetailScreenPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        UserDetailScreen(aUserWith(
            firstName = "Luz",
            lastName = "Pastor"
        ))
    }
}

fun aUserWith(firstName: String, lastName: String): User{
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