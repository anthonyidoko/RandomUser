package com.swapcard.randomusers.users.presentation

import androidx.lifecycle.ViewModel
import com.swapcard.randomusers.users.presentation.userlist.UserListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
) : ViewModel() {

    private val _state = MutableStateFlow(UserListUiState())
    val state = _state.asStateFlow()
}

