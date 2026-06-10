## 2025-05-15 - Theme Initialization Flicker
**Learning:** Initializing theme state within a `LaunchedEffect` in Jetpack Compose causes a visual flicker on app launch because the first composition uses the default value before the effect runs.
**Action:** Initialize the state directly with the system theme value (e.g., `isSystemInDarkTheme()`) during the `remember` initialization instead.

## 2025-05-15 - Proficiency Indicator Accessibility
**Learning:** Progress indicators without semantic merging and explicit state descriptions can be confusing for screen readers as the label and value may be announced separately or out of context.
**Action:** Use `semantics(mergeDescendants = true)` with `progressBarRangeInfo` and `stateDescription` to ensure they are correctly announced by screen readers as a single informative unit (e.g., "90% proficiency in Kotlin").

## 2025-05-15 - Toggle Button State Feedback
**Learning:** Icon-only buttons for state toggles (like Dark/Light mode) need a clear indication of the *active* state for screen reader users, as `contentDescription` often only describes the action.
**Action:** Add `stateDescription` to toggle buttons to indicate the currently active mode or state.
