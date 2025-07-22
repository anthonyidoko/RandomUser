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
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(CoroutineTestExtension::class)
class LoadMoreUsersShould {
    private val users = listOf(
        aUserWith("Jacob"), aUserWith("Kenneth"),
        aUserWith("Joshua"), aUserWith("NoName"),
        aUserWith("Jacob"), aUserWith("Kenneth")
    )
    private val domainUsers = domainUserWith(users)

    private val dispatchProvider = TestCoroutineDispatchProvider()
    private val usersManager = UsersManager(dispatchProvider = dispatchProvider)
    private val userRepository = TestUserRepository(domainUsers)
    private val userBookMarkUseCase = UserBookMarkUseCase(
        repository = userRepository,
        dispatchProvider = dispatchProvider
    )
    private lateinit var viewModel: UserListViewModel

    @BeforeEach
    fun setUp() {
        viewModel = UserListViewModel(
            repository = userRepository,
            usersManager = usersManager,
            userBookMarkUseCase = userBookMarkUseCase
        )
    }

    @Test
    fun setIsLoadingMore() = runTest {

        val result = collectStateFlow(stateFlow = viewModel.state) {
            viewModel.loadMoreUsers()
        }

        assertTrue(result[2].isLoadingMore)
    }

    @Test
    fun fetchUsersWithUpdatedPageNumber() = runTest {

        val result = collectStateFlow(stateFlow = viewModel.state) {
            viewModel.loadMoreUsers()
        }

        assertThat(result.last().page).isGreaterThan(1)
    }

    @Test
    fun fetchMoreUsers() = runTest {

        val stateList = collectStateFlow(stateFlow = viewModel.state) {
            viewModel.loadMoreUsers()
        }

        assertThat(stateList.last().users).isNotEmpty()
    }
}