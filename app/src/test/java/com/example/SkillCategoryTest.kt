package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
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
class SkillCategoryTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun skillCategory_titleHasHeadingSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          SkillCategory(
            title = "Programming Languages",
            skills = listOf(Pair("Kotlin", 0.9f))
          )
        }
      }
    }

    composeTestRule
      .onNode(hasText("Programming Languages") and SemanticsMatcher.expectValue(SemanticsProperties.Heading, Unit))
      .assertExists()
  }
}
