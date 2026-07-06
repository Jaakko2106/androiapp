## 2025-05-14 - Theme Initialization Flicker
**Learning:** Initializing theme state within a `LaunchedEffect` in Jetpack Compose causes a visual flicker on app launch because the first frame is rendered with the default state before the effect runs.
**Action:** Initialize the theme state directly with the system theme value (e.g., `isSystemInDarkTheme()`) during the `remember` initialization to ensure the correct theme is used from the very first frame.

## 2025-05-14 - Accessible Custom Progress Indicators
**Learning:** Custom-drawn progress indicators or standard `LinearProgressIndicator`s are not automatically fully descriptive for screen readers in Compose.
**Action:** Wrap progress indicators in a `Column` with `semantics(mergeDescendants = true)` and set `contentDescription`, `progressBarRangeInfo`, and `stateDescription` to provide a cohesive and informative announcement.

## 2025-05-14 - Navigation Tab Accessibility
**Learning:** Merging descendants in a navigation item can cause the screen reader to lose the tab's "name" if the inner `Text` or `Icon`'s description is obscured.
**Action:** When using `semantics(mergeDescendants = true)` for navigation items, explicitly set the `contentDescription` in the parent semantics block to ensure the tab's label is announced along with its role and state.
