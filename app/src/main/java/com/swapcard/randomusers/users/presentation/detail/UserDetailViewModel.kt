package com.swapcard.randomusers.users.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userBookMarkUseCase: UserBookMarkUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    val state = userDetail(savedStateHandle)
        .mapToUserDetailRoute()

    fun onBookMarkClick() {
        viewModelScope.launch {
            userBookMarkUseCase.invoke(state)
        }
    }

    fun clearUser() {

    }


}
