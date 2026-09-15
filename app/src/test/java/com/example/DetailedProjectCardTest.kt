package com.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.example.ui.theme.MyApplicationTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class DetailedProjectCardTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun detailedProjectCard_rendersContentAndAccessibility() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          DetailedProjectCard(
            title = "Project Zenith",
            description = "A high-performance cloud monitoring dashboard.",
            technologies = listOf("React", "Go"),
            linkText = "Live Demo",
            imageIcon = Icons.Outlined.Cloud,
            projectImages = listOf("https://example.com/image.png")
          )
        }
      }
    }

    composeTestRule.onNodeWithText("Project Zenith").assertIsDisplayed()
    composeTestRule.onNodeWithContentDescription("Project Zenith screenshot").assertIsDisplayed()
    composeTestRule
      .onNodeWithText("Live Demo")
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
  }
}
