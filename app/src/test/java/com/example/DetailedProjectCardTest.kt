package com.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cloud
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
class DetailedProjectCardTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun detailedProjectCard_imagesHaveIndexedContentDescriptions() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          DetailedProjectCard(
            title = "Project Zenith",
            description = "A cloud monitoring dashboard.",
            technologies = listOf("React", "Go"),
            linkText = "Live Demo",
            imageIcon = Icons.Outlined.Cloud,
            projectImages = listOf("url1", "url2")
          )
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Project Zenith screenshot 1")
      .assertIsDisplayed()

    composeTestRule
      .onNodeWithContentDescription("Project Zenith screenshot 2")
      .assertIsDisplayed()
  }
}
