package com.swapcard.randomusers.ui.userlist

import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.swapcard.randomusers.MainActivity
import com.swapcard.randomusers.di.AppModule
import com.swapcard.randomusers.di.DatabaseModule
import com.swapcard.randomusers.ui.RandomUsersAppScreenRobot
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class, DatabaseModule::class)
class UserListScreenShould {

    @get:Rule(order = 1)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun verifyMainScreenDisplaysCorrectTitle() {
        launchUserListScreen(composeRule) {
        } verify {
            topBarTitleHasCorrectText()
        }
    }

    @Test
    fun loadUsersOnScreen() {
        launchUserListScreen(composeRule) {
        } verify {
            usersLoaded()
        }
    }

    @Test
    fun performItemClick() {
        launchUserListScreen(composeRule) {
            clickFirstPersonItem()
        } verify {
            detailPageWithClickedPersonOpened()
        }
    }

    @Test
    fun addUserToBookMark() {
        launchUserListScreen(composeRule) {
            clickFirstPersonBookMarkIcon()
            navigateToBookMarkScreen()
        } verify {
            userAddedToBookMark()
        }
    }

    @Test
    fun openBookMarkScreen(){
        launchUserListScreen(composeRule){
            navigateToBookMarkScreen()
        } verify {
            bookMarkScreenOpened()
        }
    }

    private fun launchUserListScreen(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        block: RandomUsersAppScreenRobot.() -> Unit
    ): RandomUsersAppScreenRobot {
        return RandomUsersAppScreenRobot(rule).apply(block)
    }

}

