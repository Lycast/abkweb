# ABK Native - Kotlin Multiplatform & Compose HTML Portfolio

Welcome to the official repository for **[abknative.fr](https://www.abknative.fr)**.

This project serves as a technical showcase demonstrating the power of **Kotlin** for the modern Web. Unlike standard Compose Multiplatform (Canvas-based), this portfolio leverages **Compose HTML** to generate a native DOM. This ensures optimal SEO and accessibility while maintaining a shared Kotlin business logic.

## 🛠 Modern Tech Stack

* **Core Logic:** [Kotlin Multiplatform (KMP)](https://kotlinlang.org/docs/multiplatform.html) — Unified state management and routing.
* **UI Engine:** [Compose HTML](https://github.com/JetBrains/compose-multiplatform) — Reactive DOM manipulation in pure Kotlin.
* **Styling:** [Tailwind CSS](https://tailwindcss.com/) — Utility-first design system for a "Pixel Perfect" and ultra-lightweight rendering.
* **Architecture:** MVVM / Modular Components — Designed for maintainability and scalability.
* **Deployment:** GitHub Pages with custom 404 redirection for SPA (Single Page Application) support.

---

## ✨ Project Highlights

* **Native Web Performance:** Direct use of HTML tags for fast rendering and a minimal memory footprint.
* **User Experience (UX):**
    * Dynamic **Dark/Light Mode** with smooth transitions (500ms–1000ms).
    * Custom **SPA Routing** system with browser history support (`popstate`).

---

## 🏗 Project Structure (JS Optimized)

The project has been restructured to focus solely on a high-performance JS distribution, removing unnecessary mobile/Wasm targets:

```text
.
├── composeApp/
│   ├── src/jsMain/             # Primary JS/HTML source
│   │   ├── kotlin/fr.anthony.abkweb/
│   │   │   ├── components/     # Reusable UI blocks
│   │   │   ├── data/           # Data sources
│   │   │   ├── model/          # Data classes
│   │   │   ├── pages/          # Full page layouts (Home, Portfolio, Expertise)
│   │   │   ├── router/         # SPA Navigation & History logic
│   │   │   ├── theme/          # Design System (Tailwind tokens & Compose theme)
│   │   │   └── Main.kt         # Application entry point
│   │   └── resources/          # Static assets (Images, SVGs, Logos)
│   └── build.gradle.kts        # JS Build configuration & GitHub Pages task
└── README.md

---


## 📄 License & Contact

© 2026 ABK Native. All rights reserved.

Interested in unified architecture for your iOS, Android, or Web projects?

**[Get in touch via the website](https://www.google.com/search?q=https://www.abknative.fr/contact)**.