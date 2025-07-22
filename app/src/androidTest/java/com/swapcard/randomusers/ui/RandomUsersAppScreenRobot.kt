package com.swapcard.randomusers.ui

import android.content.Context
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onChildAt
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performFirstLinkClick
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import com.swapcard.randomusers.R
import com.swapcard.randomusers.TestTags
import com.swapcard.randomusers.data.users

class RandomUsersAppScreenRobot(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    private val context = rule.activity.applicationContext
    private val testTag = TestTags.tagsDefault(context)

    infix fun verify(
        block: RandomUsersAppScreenVerification.() -> Unit
    ): RandomUsersAppScreenVerification {

        return RandomUsersAppScreenVerification(rule).apply(block)
    }

    fun clickFirstPersonItem() {
        val user = users.first()
        val tag = context.getString(R.string.user_item_card, user.firstName)
        rule.onNodeWithTag(tag).performClick()
        rule.waitForIdle()
    }

    fun clickFirstPersonBookMarkIcon() {
        rule.onAllNodesWithTag(testTag.addToBookMarkIcon)
            .onFirst()
            .performClick()
        rule.waitForIdle()
    }

    fun navigateToBookMarkScreen() {
        rule.onNodeWithTag(testTag = testTag.bookMarkIcon, useUnmergedTree = true)
            .performClick()
    }

}