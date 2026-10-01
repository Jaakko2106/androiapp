## 2024-07-03 - Progress Bar Accessibility in Jetpack Compose
**Learning:** For `LinearProgressIndicator` or other progress bars, using `semantics(mergeDescendants = true)` on a parent container along with `progressBarRangeInfo` and a clear `stateDescription` (e.g., "90% proficiency") provides much better context for screen readers than the default indicator announcement.
**Action:** Always wrap proficiency indicators in a container with merged semantics and explicit state descriptions to ensure they are meaningful for accessibility users.

## 2026-09-22 - Indexed Content Descriptions for Image Galleries
**Learning:** Generic content descriptions like "Project image" on multiple carousel images cause TalkBack to repeat the exact same non-descriptive string for every item. Using `itemsIndexed` to provide contextual, numbered descriptions (e.g., "$title screenshot ${index + 1}") allows screen reader users to distinguish individual images.
**Action:** Always use `itemsIndexed` with distinct, numbered content descriptions when rendering image lists or photo carousels in Jetpack Compose.

## 2026-10-01 - Section Heading Landmarks in Jetpack Compose
**Learning:** Screen reader users (e.g. TalkBack) rely on heading landmarks to quickly jump between sections. Large styled `Text` composables do not automatically receive heading semantics unless `modifier = Modifier.semantics { heading() }` is explicitly declared.
**Action:** Always apply `semantics { heading() }` to section titles in Jetpack Compose to ensure screen reader users can navigate directly to section landmarks.
