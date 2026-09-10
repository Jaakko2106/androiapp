package com.example

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import com.example.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class AboutSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun aboutSection_profileImageHasDescriptiveContentDescription() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          AboutSection()
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Jaakko Kallio profile picture")
      .assertIsDisplayed()
  }
}
