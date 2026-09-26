package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
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
class GreetingSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun greetingSection_hasMergedHeadingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          GreetingSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Hello, I'm ", substring = true)
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
      .assert(hasText("Jaakko", substring = true))
  }
}
