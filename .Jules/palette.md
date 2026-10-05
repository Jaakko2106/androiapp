## 2024-07-03 - Progress Bar Accessibility in Jetpack Compose
**Learning:** For `LinearProgressIndicator` or other progress bars, using `semantics(mergeDescendants = true)` on a parent container along with `progressBarRangeInfo` and a clear `stateDescription` (e.g., "90% proficiency") provides much better context for screen readers than the default indicator announcement.
**Action:** Always wrap proficiency indicators in a container with merged semantics and explicit state descriptions to ensure they are meaningful for accessibility users.

## 2026-09-22 - Indexed Content Descriptions for Image Galleries
**Learning:** Generic content descriptions like "Project image" on multiple carousel images cause TalkBack to repeat the exact same non-descriptive string for every item. Using `itemsIndexed` to provide contextual, numbered descriptions (e.g., "$title screenshot ${index + 1}") allows screen reader users to distinguish individual images.
**Action:** Always use `itemsIndexed` with distinct, numbered content descriptions when rendering image lists or photo carousels in Jetpack Compose.

## 2026-10-15 - Heading Accessibility Landmarks in Jetpack Compose
**Learning:** Section title text elements without explicit semantics are read by screen readers as plain text. Adding `modifier = Modifier.semantics { heading() }` allows TalkBack users in heading navigation mode to jump directly between section titles.
**Action:** Always apply `heading()` semantics to main section title composables in Jetpack Compose.
