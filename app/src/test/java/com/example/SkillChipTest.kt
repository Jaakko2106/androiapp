package com.example

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
class SkillChipTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun skillChip_hasContentDescriptionWithSkillSuffix() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          SkillChip(text = "KOTLIN")
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("KOTLIN skill")
      .assertIsDisplayed()
  }
}
