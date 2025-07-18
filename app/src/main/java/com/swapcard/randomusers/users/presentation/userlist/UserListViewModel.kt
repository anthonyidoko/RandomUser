package com.swapcard.randomusers.users.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.repository.UsersRepository
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.domain.usecase.UsersManager
import com.swapcard.randomusers.users.domain.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
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
class UserListViewModel @Inject constructor(
    private val repository: UsersRepository,
    private val userBookMarkUseCase: UserBookMarkUseCase,
    private val usersManager: UsersManager
) : ViewModel() {

    private val _state = MutableStateFlow(UserListUiState())
    val state = _state
        .onStart {
            getBookMarkedUsers()
            fetchUsers()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UserListUiState()
        )

    private fun getBookMarkedUsers() {
        repository.getAllBookMarkedUsers()
            .onEach { bookMarked ->
                _state.update {
                    it.copy(
                        bookMarkedUsers = bookMarked
                    )
                }
            }.launchIn(viewModelScope)
    }

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
                    seed = currentState.seed,
                    count = 25
                )) {
                is Result.Success -> {
                    val bookedMarkedUsers = state.value.bookMarkedUsers
                    val updatedUsers = if (currentState.isLoadingMore) {
                        currentState.users + response.data.results.orEmpty()
                    } else {
                        response.data.results.orEmpty()
                    }
                    val mergedUsers = usersManager.manageUserUpdate(bookedMarkedUsers,updatedUsers)
                    _state.update {
                        it.copy(
                            users = mergedUsers,
                            page = response.data.info?.page ?: page
                        )
                    }
                    onLoadComplete()
                }

                is Result.Failure -> {
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

    fun onBookMarkClick(user: User) {
        viewModelScope.launch {
            userBookMarkUseCase(user)
            val managedUser = usersManager.manageUserUpdate(user, state.value.users)
            _state.update { it.copy(users = managedUser) }

        }
    }


}

