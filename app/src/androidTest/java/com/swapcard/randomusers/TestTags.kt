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
        val userCard: String,
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
        val userCard = context.getString(R.string.user_item_card)
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
            userCard = userCard
        )
    }
}