package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.swapcard.randomusers.users.domain.model.User
import kotlinx.serialization.Serializable

@Serializable
data class UserDetailRoute(
    val id: String,
    val firstName: String?,
    val lastName: String?,
    val cell: String?,
    val dob: String?,
    val email: String?,
    val gender: String?,
    val phone: String?,
    val imageUrl: String?,
    val country: String?,
    val age: Int?,
    val isFavourite: Boolean = false,
    val state: String?,
    val city: String?,
    val streetName: String?,
    val streetNumber: Int?
)

fun User.mapToUserDetailRoute(): UserDetailRoute {
    return UserDetailRoute(
        id = id,
        firstName = firstName,
        lastName = lastName,
        cell = cell,
        dob = dob,
        email = email,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        country = country,
        age = age,
        isFavourite = isFavourite,
        state = state,
        city = city,
        streetName = streetName,
        streetNumber = streetNumber
    )
}
fun UserDetailRoute.mapToUserDetailRoute(): User {
    return User(
        id = id,
        firstName = firstName,
        lastName = lastName,
        cell = cell,
        dob = dob,
        email = email,
        gender = gender,
        phone = phone,
        imageUrl = imageUrl,
        country = country,
        age = age,
        isFavourite = isFavourite,
        state = state,
        city = city,
        streetName = streetName,
        streetNumber = streetNumber
    )
}

fun NavHostController.navigateToUserDetailsListScreen(user: User) {
    navigate(user.mapToUserDetailRoute())
}

fun NavGraphBuilder.userDetailScreen(
    onBackButtonClick: () -> Unit
) {

    composable<UserDetailRoute> {
        UserDetailScreenRoot(
            onBackButtonClick = onBackButtonClick
        )
    }
}

@Composable
fun UserDetailScreenRoot(
    onBackButtonClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.primaryContainer)
            .fillMaxSize()
    ) {

        Text(text = "Detail")
    }

}

