package com.swapcard.randomusers.ui.approot

import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity

class AppRootRobot(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {

    infix fun verify(block: AppRootVerification.() -> Unit): AppRootVerification {
        return AppRootVerification(rule).apply(block)
    }
}