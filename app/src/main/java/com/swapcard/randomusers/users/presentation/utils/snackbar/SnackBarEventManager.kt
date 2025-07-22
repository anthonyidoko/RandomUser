package com.swapcard.randomusers.users.presentation.utils.snackbar

import com.swapcard.randomusers.users.presentation.BookMarkEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object SnackBarEventManager {

    private val _bookMarkChannel = Channel<BookMarkEvent>()
    val bookMarkFlow = _bookMarkChannel.receiveAsFlow()

    suspend fun sendEvent(event: BookMarkEvent){
        _bookMarkChannel.send(event)
    }
}