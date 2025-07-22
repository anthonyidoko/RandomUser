package com.swapcard.randomusers.ui

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollTo
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import com.swapcard.randomusers.R
import com.swapcard.randomusers.TestTags
import com.swapcard.randomusers.data.users
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.hamcrest.Matchers.lessThanOrEqualTo
import org.junit.Assert.assertTrue

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
        users.subList(1,5).forEach { user ->
        val tag = context.getString(R.string.user_item_card, user.firstName)
            rule.onNodeWithTag(testTag = tag)
                .assertIsDisplayed()
        }

    }

    fun detailPageWithClickedPersonOpened() {
        rule.waitForIdle()
        val user = users.first()
        val name = "${user.firstName} ${user.lastName}"
        rule.onNodeWithText(name).assertIsDisplayed()
    }

    fun userAddedToBookMark() {
        val user = users.first()
        val name = "${user.firstName} ${user.lastName}"
        rule.onNodeWithText(name)
            .assertExists()

    }

    fun bookMarkScreenOpened() {
        rule.onNodeWithTag(testTag.topBarTitle)
            .assertTextEquals(testTag.bookMarkScreenTitle)

        rule.onNodeWithTag(testTag.bookMarkEmpty)
            .assertIsDisplayed()
    }


}