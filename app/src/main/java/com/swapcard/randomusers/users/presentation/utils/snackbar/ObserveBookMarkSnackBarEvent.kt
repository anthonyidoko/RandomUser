package com.swapcard.randomusers.users.presentation.utils.snackbar

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.swapcard.randomusers.R
import com.swapcard.randomusers.users.presentation.BookMarkEvent
import com.swapcard.randomusers.users.presentation.utils.ObserveEventFlow
import kotlinx.coroutines.launch



@Composable
fun ObserveBookMarkSnackBarEvent() {
    val eventFlow = SnackBarEventManager.bookMarkFlow

    var snackBarMessage by remember {
        mutableIntStateOf(R.string.empty)
    }
    var firstName by remember {
        mutableStateOf("")
    }

    ObserveEventFlow(eventFlow) { event ->
        when (event) {
            is BookMarkEvent.OnUserAdded -> {
                snackBarMessage = R.string.user_added_to_book_mark
                firstName = event.firstName
            }

            is BookMarkEvent.OnUserRemoved -> {
                snackBarMessage = R.string.user_removed_book_mark
                firstName = event.firstName
            }
        }
    }

    val snackBarMessageS = if(snackBarMessage != R.string.empty){
        stringResource(snackBarMessage, firstName)
    }else{
        stringResource(snackBarMessage)
    }

    ShowSnackBar(
        snackBarMessageS
    )
}

@Composable
private fun ShowSnackBar(
    message: String
) {
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        LaunchedEffect(message) {
            if (message.isNotEmpty()) {
                scope.launch {
                    snackBarHostState.showSnackbar(
                        message = message,
                        duration = SnackbarDuration.Short
                    )
                }
            }

        }
        SnackbarHost(
            modifier = Modifier.align(Alignment.BottomCenter),
            hostState = snackBarHostState,
        )
    }
}