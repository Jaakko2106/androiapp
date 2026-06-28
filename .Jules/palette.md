## 2025-05-14 - Theme initialization flicker
**Learning:** Initializing theme state within a `LaunchedEffect` causes a visual flicker on app launch as the first frame is rendered with the default state.
**Action:** Initialize the state directly with the system theme value (e.g., `isSystemInDarkTheme()`) during the `remember` initialization.

## 2025-05-14 - Redundant screen reader announcements
**Learning:** Icons adjacent to descriptive text labels within the same interactive element cause redundant screen reader announcements if both have descriptions.
**Action:** Set `contentDescription` to `null` for icons and use `semantics(mergeDescendants = true)` on the parent container.

## 2025-05-14 - Progress indicator accessibility
**Learning:** Screen readers need explicit range and state information to correctly announce progress indicators like `LinearProgressIndicator`.
**Action:** Use `semantics` with `progressBarRangeInfo` and `stateDescription` to provide clear proficiency or progress levels.
