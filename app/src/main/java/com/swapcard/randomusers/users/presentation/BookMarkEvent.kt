package com.swapcard.randomusers.users.presentation

sealed interface BookMarkEvent {
    data class OnUserAdded(val firstName: String): BookMarkEvent
    data class OnUserRemoved(val firstName: String): BookMarkEvent
}
