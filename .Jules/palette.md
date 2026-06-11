## 2025-05-15 - Theme Initialization & Component Semantics
**Learning:** Initializing theme state within a `LaunchedEffect` in Jetpack Compose causes a visual flicker (one frame of default theme) on app launch. Also, standard proficiency bars (LinearProgressIndicator) require explicit `semantics` with `progressBarRangeInfo` and `stateDescription` to be accessible.
**Action:** Initialize theme state directly with the system theme value (e.g., `isSystemInDarkTheme()`) during the `remember` initialization. Always use `mergeDescendants = true` and `progressBarRangeInfo` for progress indicators.
