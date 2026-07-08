## 2026-07-08 - Compose Theme & Accessibility
**Learning:** Initializing theme state within a LaunchedEffect in Jetpack Compose causes a visual flicker on app launch; initialize state directly with the system theme value in the remember block instead. For proficiency indicators, use mergeDescendants with ProgressBarRangeInfo to ensure correct screen reader announcements.
**Action:** Always initialize theme state synchronously with system values and use explicit semantics for custom progress indicators.
