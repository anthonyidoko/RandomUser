package com.swapcard.randomusers.users.presentation.userlist

import com.swapcard.randomusers.extensions.CoroutineTestExtension
import com.swapcard.randomusers.extensions.collectStateFlow
import com.swapcard.randomusers.users.data.repository.TestUserRepository
import com.swapcard.randomusers.users.data.utils.TestCoroutineDispatchProvider
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.domain.usecase.UsersManager
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class FetchUsersShould {
    private val dispatcher = TestCoroutineDispatchProvider()
    private val usersManager = UsersManager(dispatchProvider = dispatcher)
    private val userRepository = TestUserRepository()
    private val userBookMarkUseCase = UserBookMarkUseCase(
        repository = userRepository,
        dispatchProvider = dispatcher
    )
    private lateinit var viewModel: UserListViewModel

    @BeforeEach
    fun setUp() {
        viewModel = UserListViewModel(
            repository = userRepository,
            userBookMarkUseCase = userBookMarkUseCase,
            usersManager = usersManager
        )

    }

    @Test
    fun showInitialLoadingState() = runTest {

        val result = collectStateFlow(stateFlow = viewModel.state)

        assertTrue(result.first().isLoading)
    }



}


