package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class GreetingSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun greetingSection_hasMergedSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          GreetingSection()
        }
      }
    }

    composeTestRule
      .onNode(hasText("Hello, I'm ", substring = true).and(hasText("Jaakko", substring = true)))
      .assertIsDisplayed()
  }
}
