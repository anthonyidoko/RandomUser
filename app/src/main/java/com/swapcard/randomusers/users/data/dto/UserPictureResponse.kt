package com.swapcard.randomusers.users.data.dto

import com.swapcard.randomusers.users.domain.model.UserPicture
import kotlinx.serialization.Serializable

@Serializable
data class UserPictureResponse(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)

fun UserPictureResponse.mapToDomainModel(): UserPicture {
    return UserPicture(
        large = large,
        medium  = medium,
        thumbnail = thumbnail
    )
}
