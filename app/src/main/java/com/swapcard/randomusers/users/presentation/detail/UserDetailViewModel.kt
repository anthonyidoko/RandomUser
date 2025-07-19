package com.swapcard.randomusers.users.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.presentation.utils.mapToDomainUser
import dagger.hilt.android.lifecycle.HiltViewModel
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
            _userDetailStateFlow.update {
                it.copy(
                    isFavourite = !user.isFavourite
                )
            }
            userBookMarkUseCase.invoke(user)
        }
    }


}
