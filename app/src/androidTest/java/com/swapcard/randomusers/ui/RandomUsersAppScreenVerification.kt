package com.swapcard.randomusers.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import com.swapcard.randomusers.TestTags

class RandomUsersAppScreenVerification(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    private val context = rule.activity.applicationContext
    private val testTag = TestTags.tagsDefault(context)

    fun topBarTitleHasCorrectText() {
        rule.onNodeWithTag(testTag.topBarTitle)
            .assertIsDisplayed()
            .assertTextEquals(testTag.homeScreenTitle)
    }

    fun usersLoaded() {
        rule.onAllNodesWithText(testTag.userCard)
    }

}