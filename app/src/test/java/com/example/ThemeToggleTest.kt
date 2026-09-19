package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.hasStateDescription
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
class ThemeToggleTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun headerSection_themeToggle_hasCorrectSwitchSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          HeaderSection(
            isDarkTheme = false,
            onThemeToggle = {}
          )
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Toggle Theme")
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Switch))
      .assert(hasStateDescription("Light mode active"))
  }

  @Test
  fun headerSection_themeToggle_reflectsDarkModeStateDescription() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          HeaderSection(
            isDarkTheme = true,
            onThemeToggle = {}
          )
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Toggle Theme")
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Switch))
      .assert(hasStateDescription("Dark mode active"))
  }
}
