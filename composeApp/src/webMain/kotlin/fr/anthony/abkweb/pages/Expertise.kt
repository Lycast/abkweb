package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Expertise(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        Div({ classes("container", "mx-auto", "px-6") }) {

            // --- 1. HEADER HERO ---
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto", "mb-12") }) {
                H1Custom(AppSpacing.marginM) {
                    Text("L'ingénierie ")
                    TextHighlight("text-${AppColors.accent}") { Text("Kotlin Multiplatform") }
                }

                BodyText(AppSpacing.marginL) {
                    Text("Développer des applications ne suffit plus. Je conçois des systèmes robustes, testables et capables de fonctionner de manière optimale, même en l'absence de réseau.")
                }
            }

            // --- 2. GRILLE D'EXPERTISE (2 colonnes sur Desktop, 1 sur Mobile) ---
            Div({
                classes(
                    "grid", "grid-cols-1", "md:grid-cols-2", "gap-8",
                    "max-w-6xl", "mx-auto", "w-full"
                )
            }) {
                // Carte 1 : Logique Partagée
                ExpertiseCard(
                    title = "Logique Métier Unifiée",
                    description = "Mutualisation des règles métier, des modèles de données et de la logique réseau. Un seul code source Kotlin à tester et à maintenir pour iOS, Android et Web, réduisant drastiquement la dette technique et les bugs."
                )

                // Carte 2 : Offline-First
                ExpertiseCard(
                    title = "Approche Offline-First",
                    description = "L'utilisateur ne doit jamais être bloqué par une perte de réseau. Utilisation avancée de Room/SQLite et des Coroutines pour une persistance locale fiable et une synchronisation transparente en arrière-plan."
                )

                // Carte 3 : Backend Ktor
                ExpertiseCard(
                    title = "Backend Ktor & API",
                    description = "Création d'infrastructures serveurs légères et ultra-performantes 100% Kotlin. Développement d'API RESTful robustes et gestion de la synchronisation en temps réel via WebSockets."
                )

                // Carte 4 : NOUVELLE CARTE MIGRATION
                ExpertiseCard(
                    title = "Modernisation & Migration KMP",
                    description = "Audit et refactoring progressif d'applications natives existantes. Introduction de Kotlin Multiplatform en douceur pour partager la logique métier étape par étape, sans avoir à réécrire l'interface utilisateur ou perturber la production."
                )
            }

            // --- 3. SECTION TECHNOLOGIES (Tags visuels) ---
            Div({
                classes(
                    "flex",
                    "flex-col",
                    "items-center",
                    "text-center",
                    "max-w-4xl",
                    "mx-auto",
                    "mt-12",
                    "gap-8"
                )
            }) {
                H2Custom { Text("Stack Technique Maîtrisée") }

                Div({ classes("flex", "flex-wrap", "justify-center", "gap-4") }) {
                    TechBadge("Kotlin")
                    TechBadge("Jetpack Compose")
                    TechBadge("Compose HTML")
                    TechBadge("Ktor")
                    TechBadge("Coroutines & Flow")
                    TechBadge("Room / SQLite")
                    TechBadge("Clean Architecture")
                }
            }

            // --- 4. CTA FINAL ---
            Div({ classes("flex", "flex-col", "items-center", "text-center", "mt-16", "mb-8") }) {
                SecondaryButton("Discuter de vos besoins techniques →") {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}

// --- SOUS-COMPOSANTS PRIVÉS (Spécifiques à la page Expertise) ---
@Composable
private fun ExpertiseCard(title: String, description: String) {
    Div({
        classes(
            *AppColors.border, AppShapes.card, "p-8",
            "flex", "flex-col", "gap-4",
            *AppColors.themeTransition
        )
    }) {
        H3Custom { Text(title) }
        BodyText { Text(description) }
    }
}

@Composable
private fun TechBadge(name: String) {
    Span({
        classes(
            *AppColors.bgAlt, *AppColors.textPrimary, *AppColors.border,
            "px-5", "py-2", AppShapes.card, "text-sm", "font-bold",
            *AppColors.themeTransition
        )
    }) {
        Text(name)
    }
}