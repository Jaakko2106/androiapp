## 2025-06-07 - Jetpack Compose Theme Flicker
**Learning:** Initializing theme state within a `LaunchedEffect` causes a visible "flash" of the default theme before the system theme is applied.
**Action:** Always initialize theme-related `remember` states directly with the system value (e.g., `isSystemInDarkTheme()`) to ensure the correct theme is used from the very first frame.

## 2025-06-07 - Accessibility for Skill Progress Bars
**Learning:** Decorative progress bars (like skill bars) are often invisible to screen readers unless explicitly marked with semantics.
**Action:** Use `semantics(mergeDescendants = true)` and provide `progressBarRangeInfo` and `stateDescription` to make these visual indicators meaningful for accessibility users.
