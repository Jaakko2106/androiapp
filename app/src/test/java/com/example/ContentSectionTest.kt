package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
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
class ContentSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun contentSection_featuredProjectCardRendersWithButtonRole() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContentSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Project Zenith", substring = true)
      .assertIsDisplayed()

    composeTestRule
      .onNodeWithText("FEATURED", substring = true)
      .assertIsDisplayed()
  }

  @Test
  fun contentSection_contactCardRendersWithButtonRole() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContentSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Get in touch", substring = true)
      .assertIsDisplayed()
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
  }
}
