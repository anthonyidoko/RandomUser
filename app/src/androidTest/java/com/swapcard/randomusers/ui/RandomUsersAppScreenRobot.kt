package com.swapcard.randomusers.ui

import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity

class RandomUsersAppScreenRobot(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {

    infix fun verify(
        block: RandomUsersAppScreenVerification.() -> Unit
    ): RandomUsersAppScreenVerification {

        return RandomUsersAppScreenVerification(rule).apply(block)
    }
}