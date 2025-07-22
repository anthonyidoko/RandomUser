package com.swapcard.randomusers

import android.content.Context

object TestTags {
    data class TestTags(
        val topBar: String,
        val topBarTitle: String,
        val bottomBar: String,
        val homeBottomNav: String,
        val bookMarkBottomNav: String,
        val homeText: String,
        val bookMarkIconCD: String,
        val bookMarkLabel: String,
        val homeIconCD: String,
        val homeScreenTitle: String,
        val lazyColumn: String,
        val bookMarkIcon: String,
        val addToBookMarkIcon: String,
        val bookMarkScreenTitle: String,
        val bookMarkEmpty: String
    )

    fun tagsDefault(context: Context): TestTags {
        val topBar = context.getString(R.string.top_bar_test_tag)
        val topBarTitle = context.getString(R.string.top_bar_test_title)
        val bottomBar = context.getString(R.string.bottom_bar_test_tag)
        val homeBottomNav = context.getString(R.string.home_navigation_item)
        val bookMarkBottomNav = context.getString(R.string.bookmark_navigation_item)
        val bookMarkLabel = context.getString(R.string.bookmarked_label)
        val homeText = context.getString(R.string.home)
        val bookMarkCD = context.getString(R.string.bookmarked_icon)
        val homeIconCD = context.getString(R.string.home_icon)
        val homeScreenTitle = context.getString(R.string.users)
        val lazyColumTag = context.getString(R.string.lazy_column_tag)
        val addToBookMarkIcon = context.getString(R.string.add_to_bookmarked_icon_test_tag)
        val bookMarkIcon = context.getString(R.string.bookmarked_icon)
        val bookMarkScreenTitle = context.getString(R.string.bookmarked_users)
        val bookMarkEmpty = context.getString(R.string.book_mark_empty_test_tag)
        return TestTags(
            topBar = topBar,
            topBarTitle = topBarTitle,
            bottomBar = bottomBar,
            homeBottomNav = homeBottomNav,
            bookMarkBottomNav = bookMarkBottomNav,
            homeText = homeText,
            bookMarkIconCD = bookMarkCD,
            bookMarkLabel = bookMarkLabel,
            homeIconCD = homeIconCD,
            homeScreenTitle = homeScreenTitle,
            lazyColumn = lazyColumTag,
            bookMarkIcon = bookMarkIcon,
            addToBookMarkIcon = addToBookMarkIcon,
            bookMarkScreenTitle = bookMarkScreenTitle,
            bookMarkEmpty = bookMarkEmpty
        )
    }
}