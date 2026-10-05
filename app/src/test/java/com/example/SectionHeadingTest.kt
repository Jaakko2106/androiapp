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
          AboutSection()
          ContactSection()
        }
      }
    }

    composeTestRule
      .onNodeWithText("Projects")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))

    composeTestRule
      .onNodeWithText("Skills & Expertise")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))

    composeTestRule
      .onNodeWithText("Contact")
      .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
  }
}
