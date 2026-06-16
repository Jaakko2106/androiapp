## 2025-05-14 - Theme Flicker & Accessibility Polish
**Learning:** Initializing theme state within a LaunchedEffect causes a visible flicker on launch; direct initialization in remember with isSystemInDarkTheme() is smoother. Semantic properties like 'selected' for tabs and 'progressBarRangeInfo' for progress bars are crucial for meaningful screen reader experiences in Compose.
**Action:** Always initialize theme state directly with system preference. Ensure interactive components like tabs and progress indicators have appropriate semantic roles and state descriptions.
