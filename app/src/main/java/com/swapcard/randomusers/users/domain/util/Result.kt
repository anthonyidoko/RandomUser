package com.swapcard.randomusers.users.domain.util

sealed interface Result<out T> {
    data class Success<out T>(val data: T) : Result<T>
    sealed interface Error<out T> : Result<T> {
        sealed interface NetworkError : Error<Nothing> {
            data class ServerError(val message: String?) : NetworkError
        }

        sealed interface LocalError : Error<Nothing> {
        }
    }
}

