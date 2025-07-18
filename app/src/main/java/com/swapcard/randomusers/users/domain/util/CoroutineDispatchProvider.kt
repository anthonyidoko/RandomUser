package com.swapcard.randomusers.users.domain.util

import kotlinx.coroutines.CoroutineDispatcher

interface CoroutineDispatchProvider {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}
