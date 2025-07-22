package com.swapcard.randomusers.users.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.presentation.BookMarkEvent
import com.swapcard.randomusers.users.presentation.utils.mapToDomainUser
import com.swapcard.randomusers.users.presentation.utils.snackbar.SnackBarEventManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userBookMarkUseCase: UserBookMarkUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _userDetailStateFlow = userDetailStateFlow(savedStateHandle)
    val state: StateFlow<UserDetailRoute> = _userDetailStateFlow

    fun onBookMarkClick() {
        viewModelScope.launch {
            val user = state.value.mapToDomainUser()
            userBookMarkUseCase.invoke(user)
            sendBookMarkEvent(user)
            _userDetailStateFlow.update {
                it.copy(
                    isFavourite = !user.isFavourite
                )
            }

        }
    }

    private suspend fun sendBookMarkEvent(user: User) {
        val firstName = user.firstName.orEmpty()
        val event = if (user.isFavourite) {
            BookMarkEvent.OnUserRemoved(firstName)
        } else {
            BookMarkEvent.OnUserAdded(firstName)
        }

        SnackBarEventManager.sendEvent(event)
    }


}
