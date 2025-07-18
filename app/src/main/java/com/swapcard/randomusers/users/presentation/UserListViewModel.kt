package com.swapcard.randomusers.users.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.util.Result
import com.swapcard.randomusers.users.presentation.userlist.UserListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val repository: UsersRepository
) : ViewModel() {

    private val _state = MutableStateFlow(UserListUiState())
    val state = _state
        .onStart { fetchUsers() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserListUiState()
        )

    private fun fetchUsers() {
        viewModelScope.launch {
            val currentState = state.value
            val page = currentState.page + 1
            _state.update {
                it.copy(
                    isLoading = (!currentState.isLoadingMore && !currentState.isRefreshing)
                )
            }
            when (
                val response = repository.fetchUsers(
                    page = page,
//                seed = currentState.seed
                )) {
                is Result.Success -> {
                    val updatedUsers = if (currentState.isLoadingMore) {
                        currentState.users + response.data.results.orEmpty()
                    } else {
                        response.data.results.orEmpty()
                    }
                    _state.update {
                        it.copy(
                            users = updatedUsers,
                            page = response.data.info?.page ?: page
                        )
                    }
                    onLoadComplete()
                }

                is Result.Error -> {
                    onLoadComplete()
                }
            }
        }
    }

    private fun onLoadComplete() {
        _state.update {
            it.copy(
                isLoading = false,
                isLoadingMore = false,
                isRefreshing = false
            )
        }
    }

    fun loadMoreUsers() {
        _state.update {
            it.copy(
                isLoadingMore = true
            )
        }
        fetchUsers()
    }

    fun refreshUserList() {
        _state.update {
            it.copy(
                isRefreshing = true,
                page = 0
            )
        }
        fetchUsers()
    }


}

