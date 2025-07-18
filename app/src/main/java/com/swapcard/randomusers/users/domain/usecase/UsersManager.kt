package com.swapcard.randomusers.users.domain.usecase

import androidx.compose.runtime.toMutableStateMap
import com.swapcard.randomusers.users.domain.model.User
import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UsersManager @Inject constructor(
    private val dispatchProvider: CoroutineDispatchProvider
) {

    fun combine(first: List<User>, second: List<User>): List<User> {
        val result = mutableListOf<User>()
        val highPriorityUsers: MutableMap<String, User> =
            first.map { it.id to it }.toMutableStateMap()

        second.forEach { user ->
            if (user.id in highPriorityUsers) {
                val updatedUser = user.copy(isFavourite = true)
                result.add(updatedUser)
                highPriorityUsers.remove(user.id)
            } else {
                result.add(user.copy(isFavourite = false))
            }
        }

        result.addAll(0, highPriorityUsers.values)

        return result
    }

    suspend fun manageUserUpdate(updatedUser: User, users: List<User>): List<User> {
        return withContext(dispatchProvider.default) {
            val result = mutableListOf<User>()
            for (user in users) {
                if (user.id != updatedUser.id) {
                    result.add(user)
                }
            }

            if (updatedUser.isFavourite) {
                result.add(updatedUser.copy(isFavourite = false))
            } else {
                result.add(0, updatedUser.copy(isFavourite = true))
            }
            result
        }
    }

    suspend fun manageUserUpdate(highPriorityUsers: List<User>, others: List<User>): List<User> {
        return withContext(dispatchProvider.default) {
            val priority = highPriorityUsers.map { it.id }.toSet()
            val result = mutableListOf<User>()

            for (user in others) {
                if (user.id !in priority) {
                    result.add(user)
                }
            }

            result.addAll(0, highPriorityUsers)
            result
        }
    }
}
