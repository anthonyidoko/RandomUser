package com.swapcard.randomusers.users.presentation.utils

import androidx.compose.foundation.lazy.LazyListState

object Pagination {
    fun LazyListState.isCloseToEnd(offset: Int = 5): Boolean{
        val lastVisibleItemIndex = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: return false
        return lastVisibleItemIndex >= layoutInfo.totalItemsCount-offset
    }
}