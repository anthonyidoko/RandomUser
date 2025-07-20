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
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class FetchUsersShould {

    @Test
    fun showInitialLoadingState() = runTest {

        val dispatcher = TestCoroutineDispatchProvider()
        val usersManager = UsersManager(dispatchProvider = dispatcher)
        val userRepository = TestUserRepository()
        val userBookMarkUseCase = UserBookMarkUseCase(
            repository = userRepository,
            dispatchProvider = dispatcher
        )
        val viewModel = UserListViewModel(
            repository = userRepository,
            userBookMarkUseCase = userBookMarkUseCase,
            usersManager = usersManager
        )

        val result = collectStateFlow(stateFlow = viewModel.state)

        assertTrue(result.first().isLoading)
    }

}


