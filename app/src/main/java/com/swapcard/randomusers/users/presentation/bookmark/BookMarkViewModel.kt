package com.swapcard.randomusers.users.presentation.bookmark

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookMarkViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val userBookMarkUseCase: UserBookMarkUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(BookMarkUiState())
    val state = _state.onStart {
        loadBookMarkedUsers()
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = BookMarkUiState()
        )

    private fun loadBookMarkedUsers() {
        repository.getAllBookMarkedUsers()
            .onEach { users ->
                _state.update {
                    it.copy(users = users)
                }
            }.launchIn(viewModelScope)
    }

    fun onBookMarkClick(user: User) {
        viewModelScope.launch {
            userBookMarkUseCase.invoke(user)
        }
    }


}