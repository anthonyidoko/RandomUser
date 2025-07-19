package com.swapcard.randomusers.users.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.SavedStateHandle
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

val userDetail: (SavedStateHandle) -> UserDetailRoute = {
    val id = requireNotNull(it.get<String>("id"))
    val firstName = requireNotNull(it.get<String>("firstName"))
    val lastName = requireNotNull(it.get<String>("lastName"))
    val cell = requireNotNull(it.get<String>("cell"))
    val dob = requireNotNull(it.get<String>("dob"))
    val email = requireNotNull(it.get<String>("email"))
    val gender = requireNotNull(it.get<String>("gender"))
    val phone = requireNotNull(it.get<String>("phone"))
    val imageUrl = requireNotNull(it.get<String>("imageUrl"))
    val country = requireNotNull(it.get<String>("country"))
    val age: Int = requireNotNull(it.get<Int>("age"))
    val isFavourite = requireNotNull(it.get<Boolean>("isFavourite"))
    val state = requireNotNull(it.get<String>("state"))
    val city = requireNotNull(it.get<String>("city"))
    val streetName = requireNotNull(it.get<String>("streetName"))
    val streetNumber = requireNotNull(it.get<Int>("streetNumber"))

    UserDetailRoute(
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


@Preview
@Composable
fun RectangularImageCardPreview() {
    UserRectangularImage(
        firstName = "Wakanda",
        url = ""
    )
}

