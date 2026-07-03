## 2024-07-03 - Progress Bar Accessibility in Jetpack Compose
**Learning:** For `LinearProgressIndicator` or other progress bars, using `semantics(mergeDescendants = true)` on a parent container along with `progressBarRangeInfo` and a clear `stateDescription` (e.g., "90% proficiency") provides much better context for screen readers than the default indicator announcement.
**Action:** Always wrap proficiency indicators in a container with merged semantics and explicit state descriptions to ensure they are meaningful for accessibility users.
