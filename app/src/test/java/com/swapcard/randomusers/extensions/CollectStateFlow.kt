package com.swapcard.randomusers.extensions

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.toCollection
import kotlinx.coroutines.launch

fun <T> CoroutineScope.collectStateFlow(
    stateFlow: StateFlow<T>,
    dropInitial: Boolean = true,
    dispatcher: CoroutineDispatcher = Dispatchers.Unconfined,
    block: () -> Unit = {}
): List<T> {

    val result = mutableListOf<T>()
    val job = launch(dispatcher) {
        stateFlow.toCollection(result)
    }

    block()
    job.cancel()

    return if (dropInitial) result.drop(1) else result
}