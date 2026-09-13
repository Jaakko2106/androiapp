package com.example

import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
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
class ContactSectionTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun contactSection_cardsHaveMergedSemanticsAndRole() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          ContactSection()
        }
      }
    }

    composeTestRule
      .onNode(hasText("Email Me"))
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))

    composeTestRule
      .onNode(hasText("LinkedIn"))
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Button))
  }
}
