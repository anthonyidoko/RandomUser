package com.swapcard.randomusers.ui.approot

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import com.swapcard.randomusers.TestTags

class AppRootVerification(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    private val context = rule.activity.applicationContext
    private val tags = TestTags.tagsDefault(context)

    fun appBarIsDisplayed() {
        rule.onNodeWithTag(tags.topBar).assertIsDisplayed()
    }

    fun bottomBarIsVisible() {
        rule.onNodeWithTag(tags.bottomBar).assertIsDisplayed()
    }

    fun homeNavigationItemIsVisible() {
        rule.onNodeWithTag(tags.homeBottomNav).assertIsDisplayed()
        displayIconWith(tags.homeIconCD)
        isTextDisplayed(tags.homeText)
    }

    fun bookMarkNavigationItemIsVisible() {
        rule.onNodeWithTag(tags.bookMarkBottomNav).assertIsDisplayed()
        displayIconWith(tags.bookMarkIconCD)
        isTextDisplayed(tags.bookMarkLabel)
    }

    private fun displayIconWith(contentDescription: String) {
        rule.onNodeWithContentDescription(contentDescription, useUnmergedTree = true).assertIsDisplayed()
    }

    private fun isTextDisplayed(testTag: String) {
        rule.onNodeWithText(testTag)
            .assertIsDisplayed()
    }
}