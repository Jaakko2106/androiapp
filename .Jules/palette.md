## 2025-05-14 - Eliminating Redundant Screen Reader Announcements
**Learning:** Setting `contentDescription` on icons that are immediately adjacent to descriptive text labels (e.g., in buttons or nav items) leads to redundant announcements by screen readers, creating a cluttered and confusing user experience.
**Action:** Set `contentDescription = null` for icons that are purely decorative or whose purpose is already explained by a nearby text label within the same interactive element.

## 2025-05-14 - Semantic Proficiency Indicators
**Learning:** Visual-only progress bars (like skill proficiency indicators) are invisible to screen reader users unless explicitly annotated. Using `semantics(mergeDescendants = true)` with `progressBarRangeInfo` and a clear `stateDescription` ensures these indicators are both discoverable and accurately described.
**Action:** For any custom progress or level indicator, use `mergeDescendants = true` on the parent container and provide both the numeric range info and a human-readable state description.
