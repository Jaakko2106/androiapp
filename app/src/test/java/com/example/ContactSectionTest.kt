package com.example

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ContactSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun contactSection_rendersCorrectly() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContactSection()
        }
      }
    }

    composeTestRule.onNodeWithText("Contact").assertIsDisplayed()
    composeTestRule.onNodeWithText("Email Me").assertIsDisplayed()
    composeTestRule.onNodeWithText("LinkedIn").assertIsDisplayed()
  }
}
