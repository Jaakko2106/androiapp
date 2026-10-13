package com.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
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
class StatsCardTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun statsCard_hasMergedSemanticsAndButtonRole() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          StatsCard(
            icon = Icons.Outlined.Terminal,
            title = "Tech Stack",
            subtitle = "12+ Technologies"
          )
        }
      }
    }

    composeTestRule
      .onNodeWithText("Tech Stack", substring = true)
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
  }
}
