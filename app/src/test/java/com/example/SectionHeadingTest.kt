package com.example

import androidx.compose.material3.Surface
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
class SectionHeadingTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun sectionTitles_haveHeadingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ProjectsSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Projects")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
  }

  @Test
  fun aboutSectionTitle_hasHeadingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          AboutSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Skills & Expertise")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
  }

  @Test
  fun contactSectionTitle_hasHeadingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContactSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Contact")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
  }
}
