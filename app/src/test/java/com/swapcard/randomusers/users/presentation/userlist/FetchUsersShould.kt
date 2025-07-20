package com.swapcard.randomusers.users.presentation.userlist

import com.google.common.truth.Truth.assertThat
import com.swapcard.randomusers.extensions.CoroutineTestExtension
import com.swapcard.randomusers.extensions.collectStateFlow
import com.swapcard.randomusers.users.data.repository.TestUserRepository
import com.swapcard.randomusers.users.data.utils.TestCoroutineDispatchProvider
import com.swapcard.randomusers.users.data.utils.aUserWith
import com.swapcard.randomusers.users.data.utils.domainUserWith
import com.swapcard.randomusers.users.domain.usecase.UserBookMarkUseCase
import com.swapcard.randomusers.users.domain.usecase.UsersManager
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class FetchUsersShould {
    private val users = listOf(
        aUserWith("Jacob"), aUserWith("Kenneth"),
        aUserWith("Joshua"), aUserWith("NoName"),
        aUserWith("Jacob"), aUserWith("Kenneth")
    )
    private val domainUsers = domainUserWith(users)

    private val dispatcher = TestCoroutineDispatchProvider()
    private val usersManager = UsersManager(dispatchProvider = dispatcher)
    private val emptyUserRepository = TestUserRepository()
    private val userRepositoryWithData = TestUserRepository(domainUsers)
    private val userBookMarkUseCase = UserBookMarkUseCase(
        repository = userRepositoryWithData,
        dispatchProvider = dispatcher
    )

    @Test
    fun showInitialLoadingState() = runTest {
        val viewModel = UserListViewModel(
            repository = emptyUserRepository,
            userBookMarkUseCase = userBookMarkUseCase,
            usersManager = usersManager
        )

        val result = collectStateFlow(stateFlow = viewModel.state)

        assertTrue(result.first().isLoading)
    }

    @Test
    fun fetchBookMarkedUsers() = runTest {
        val viewModel = UserListViewModel(
            repository = userRepositoryWithData,
            userBookMarkUseCase = userBookMarkUseCase,
            usersManager = usersManager
        )

        viewModel.onBookMarkClick(users[0])
        val result = collectStateFlow(stateFlow = viewModel.state)

        assertThat(result.last().bookMarkedUsers).isNotEmpty()
    }

    @Test
    fun fetchUsers() = runTest {
        val viewModel = UserListViewModel(
            repository = userRepositoryWithData,
            userBookMarkUseCase = userBookMarkUseCase,
            usersManager = usersManager
        )

        val result = collectStateFlow(viewModel.state)

        assertThat(result.last().users).isNotEmpty()
    }

    @Test
    fun captureError() = runTest {
        val viewModel = UserListViewModel(
            repository = emptyUserRepository,
            usersManager = usersManager,
            userBookMarkUseCase = userBookMarkUseCase
        )

        val result = collectStateFlow(viewModel.state)

        assertThat(result.last().errorResId).isNotNull()
    }


}


