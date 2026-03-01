# ABK Native - Expert Kotlin Multiplatform Portfolio

This repository contains the source code for **[abknative.fr](https://www.abknative.fr)**.

Built from the ground up using **Kotlin Multiplatform (KMP)** and **Compose HTML**, this project demonstrates how to achieve native-level web performance while sharing a robust Kotlin logic base.

## 🛠 Tech Stack

* **Core Engine:** [Kotlin Multiplatform (KMP)](https://kotlinlang.org/docs/multiplatform.html) — Unified logic across platforms.
* **UI Framework:** [Compose HTML](https://github.com/JetBrains/compose-multiplatform) — Reactive web UI built entirely in Kotlin.
* **Styling:** [Tailwind CSS](https://tailwindcss.com/) — Utility-first CSS for a responsive, "Pixel Perfect" layout.
* **Routing:** Custom SPA Router with `popstate` history support and automatic 404 handling.
* **Theming:** Dynamic Dark/Light mode with system preference sync and seamless transitions.

---

## ✨ Key Features

* **Unified Development:** Utilizing a modern KMP structure with dedicated `webMain` and `wasmJs` targets.
* **Seamless Transitions:** UI elements and background colors synchronized with a 500ms–1000ms transition for a premium feel.
* **Production-Ready Routing:** Handles direct URL access and browser navigation via a specialized `404.html` redirection logic.
* **Automated Deployment:** CI/CD pipeline delivering the static build to GitHub Pages via a custom OVH domain.

---

## 🏗 Project Structure

Reflecting the optimized **CMP (Compose Multiplatform)** architecture:

```text
.
├── composeApp/                 # Main application module
│   ├── src/webMain/kotlin/     # Main Kotlin source code
│   │   └── fr.anthony.abkweb/
│   │       ├── components/     # UI Building blocks (Header, Footer, Blocks)
│   │       ├── pages/          # Full page layouts (Home, Expertise, etc.)
│   │       ├── router/         # SPA Navigation & History logic
│   │       ├── theme/          # Centralized Colors, Spacing, and Typography
│   │       └── main.kt         # Application entry point
│   └── build.gradle.kts        # KMP & Compose build configuration
├── gradle/                     # Build system configuration
└── README.md                   # This file

```

---

## ⚙️ Development & Build

This project uses the Gradle build system to manage its multiplatform targets.

* **Run in Development Mode:** `./gradlew jsBrowserDevelopmentRun --continuous`
* **Generate Production Build:** `./gradlew jsBrowserDistribution`

The production-ready assets are generated in `composeApp/build/dist/js/productionExecutable`.

---

## 📄 License & Contact

© 2026 ABK Native. All rights reserved.

Interested in unified architecture for your iOS, Android, or Web projects?

**[Get in touch via the website](https://www.google.com/search?q=https://www.abknative.fr/contact)**.
