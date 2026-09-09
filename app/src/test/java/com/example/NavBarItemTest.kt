package com.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.hasContentDescription
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
class NavBarItemTest {

  @get:Rule val composeTestRule = createComposeRule()

  @Test
  fun navBarItem_hasCorrectMergedSemantics() {
    composeTestRule.setContent {
      MyApplicationTheme {
        Surface {
          NavBarItem(
            icon = Icons.Outlined.Home,
            label = "Home",
            isSelected = true,
            onClick = {}
          )
        }
      }
    }

    composeTestRule
      .onNodeWithContentDescription("Home")
      .assertIsSelected()
      .assert(SemanticsMatcher.expectValue(SemanticsProperties.Role, Role.Tab))
  }
}
