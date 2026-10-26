package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
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
class SectionHeadingsTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun projectsSection_headingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ProjectsSection()
        }
      }
    }

    composeTestRule
      .onNode(hasText("Projects") and SemanticsMatcher.expectValue(SemanticsProperties.Heading, Unit))
      .assertIsDisplayed()
  }

  @Test
  fun aboutSection_headingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          AboutSection()
        }
      }
    }

    composeTestRule
      .onNode(hasText("Skills & Expertise") and SemanticsMatcher.expectValue(SemanticsProperties.Heading, Unit))
      .assertIsDisplayed()
  }

  @Test
  fun contactSection_headingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContactSection()
        }
      }
    }

    composeTestRule
      .onNode(hasText("Contact") and SemanticsMatcher.expectValue(SemanticsProperties.Heading, Unit))
      .assertIsDisplayed()
  }
}
