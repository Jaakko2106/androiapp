## 2025-05-14 - Proficiency Indicator Accessibility
**Learning:** Standard LinearProgressIndicator in Compose doesn't announce progress values or state to screen readers by default, leaving vision-impaired users without context for skill levels.
**Action:** Always use `semantics(mergeDescendants = true)` with `progressBarRangeInfo` and `stateDescription` on progress indicators to ensure meaningful progress announcements and provide a visual percentage label for better immediate clarity.
