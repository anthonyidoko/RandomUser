package com.swapcard.randomusers.ui.approot

import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import org.junit.Rule
import org.junit.Test

class AppRootShould {

    @get:Rule
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun showTopBar() {
        launchMainScreen(composeRule) {
            // Do nothing
        } verify { appBarIsDisplayed() }
    }

    @Test
    fun showBottomBar() {
        launchMainScreen(composeRule) {
            //Do nothing
        } verify {
            bottomBarIsVisible()
        }
    }

    @Test
    fun showHomeNavigationItem() {
        launchMainScreen(composeRule) {

        } verify {
            homeNavigationItemIsVisible()
        }
    }

    @Test
    fun showBookMarkNavigationItem() {
        launchMainScreen(composeRule) {
        } verify {
            bookMarkNavigationItemIsVisible()
        }
    }


    private fun launchMainScreen(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        block: AppRootRobot.() -> Unit
    ): AppRootRobot = AppRootRobot(rule).apply(block)

}


