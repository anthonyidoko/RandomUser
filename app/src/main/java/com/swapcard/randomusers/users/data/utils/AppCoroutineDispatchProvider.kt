package com.swapcard.randomusers.users.data.utils

import com.swapcard.randomusers.users.domain.util.CoroutineDispatchProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class AppCoroutineDispatchProvider: CoroutineDispatchProvider {
    override val main: CoroutineDispatcher = Dispatchers.Main

    override val default: CoroutineDispatcher = Dispatchers.Default

    override val io: CoroutineDispatcher = Dispatchers.IO

    override val unconfined: CoroutineDispatcher = Dispatchers.Unconfined

}