## 2026-06-08 - Fixed Theme Initialization Flicker
**Learning:** Initializing theme state within a `LaunchedEffect` in Jetpack Compose causes a visual flicker on app launch because the first frame is rendered with the default state before the `LaunchedEffect` updates it.
**Action:** Initialize the state directly with the system theme value (e.g., `isSystemInDarkTheme()`) during the `remember` initialization instead of using `LaunchedEffect`.

## 2026-06-08 - Accessible Progress Bars in Compose
**Learning:** Standard progress bars in Jetpack Compose are often not automatically announced with their value or purpose by screen readers.
**Action:** Use `semantics(mergeDescendants = true)` with `progressBarRangeInfo` and `stateDescription` to ensure they are correctly announced.
