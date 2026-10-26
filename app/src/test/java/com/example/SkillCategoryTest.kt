package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.ProgressBarRangeInfo
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
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
class SkillCategoryTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun skillCategory_itemHasCorrectMergedSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          SkillCategory(
            title = "Languages",
            skills = listOf(Pair("Kotlin", 0.9f))
          )
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Kotlin")
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.StateDescription, "90% proficiency"))
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.ProgressBarRangeInfo, ProgressBarRangeInfo(0.9f, 0f..1f)))
  }
}
