## 2025-06-14 - Compose Theme Flicker & Accessibility Semantics
**Learning:** Initializing theme state with `LaunchedEffect` causes a visual flicker. Accessibility for custom progress indicators and bottom navigation must be explicitly defined using `semantics` (e.g., `progressBarRangeInfo`, `stateDescription`, `selected`).
**Action:** Always initialize theme state directly in the `remember` block using system settings. Use `semantics` blocks to provide rich metadata for custom UI elements to ensure they are screen-reader friendly.
