package com.swapcard.randomusers.users.domain.util

sealed interface Result<out T, out D: DataError> {
    data class Success<out T, out D: DataError>(val data: T, val error: DataError? = null) :
        Result<T, D>

    data class Failure<out T, out D: DataError>(val error: D) : Result<T, D>
}

interface Error

interface DataError : Error {
    enum class Network : DataError {
        UnknownException,
        SerializationException,
        TimeoutException,
        UnAuthorized,
        NotFound,
        ServerError
    }

}