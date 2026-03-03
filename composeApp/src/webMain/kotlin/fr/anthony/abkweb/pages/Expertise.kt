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
                    Text("Je ne crée pas d'applications isolées, mais des systèmes robustes conçus pour durer. Je mise sur une architecture testable et une synchronisation intelligente pour assurer une performance constante, avec ou sans connexion internet.")
                }
            }

            // --- 2. GRILLE D'EXPERTISE (3 colonnes sur Desktop, 1 sur Mobile) ---
            Div({
                classes(
                    "grid", "grid-cols-1", "md:grid-cols-3", "gap-8",
                    "max-w-6xl", "mx-auto", "w-full"
                )
            }) {
                // Carte 1 : Logique Partagée
                ExpertiseCard(
                    title = "Logique Métier Unifiée",
                    description = "Mutualisation des règles métier, des modèles de données et de la logique réseau. Un seul code source Kotlin à tester et à maintenir pour iOS, Android et Web, réduisant drastiquement la dette technique et les bugs."
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
                    "mx-auto",
                    "mt-12",
                    "pt-12",
                    "gap-8"
                )
            }) {
                H2Custom { Text("Stack Technique Maîtrisée") }

                Div({ classes("flex", "flex-wrap", "justify-center", "gap-2") }) {
                    TechBadge("Kotlin")
                    TechBadge("Kotlin Multiplatform (KMP)")
                    TechBadge("Jetpack Compose & SwiftUI")
                    TechBadge("Compose HTML")
                    TechBadge("Ktor")
                    TechBadge("Coroutines & Flow")
                    TechBadge("Room / SQLDelight")
                    TechBadge("Koin")
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
            *AppColors.border, AppShapes.button, "p-8",
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
            "px-5", "py-2", AppShapes.button, "text-sm", "font-bold",
            *AppColors.themeTransition
        )
    }) {
        Text(name)
    }
}