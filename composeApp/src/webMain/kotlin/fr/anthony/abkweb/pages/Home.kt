package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.FeatureBlock
import fr.anthony.abkweb.components.ImageCard
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Home(
    onNavigate: (Page) -> Unit
) {

    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        Div({ classes("container", "mx-auto", "px-6") }) {

            // --- 1. SECTION HERO ---
            Div({ classes(
                "text-center", "animate-fade-in",
                *AppSpacing.sectionTight
            )
            }) {
                H1Custom(AppSpacing.marginM) {
                    Text("L'architecture ")
                    TextHighlight("text-${AppColors.accent}") { Text("Kotlin Multiplatform") }
                    Br()
                    Text("au service de votre métier")
                }

                BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", AppSpacing.marginL)) {
                    Text("Développeur Fullstack spécialisé KMP. Je conçois des applications mobiles et web unifiées avec un seul code source pour une performance native.")
                }
            }

            // --- 2. BLOCS NARRATIFS ---
            Div({ classes("flex", "flex-col", "w-full", "animate-fade-in-up") }) {

                // BLOC 1 : L'Expertise (Image à droite par défaut)
                FeatureBlock(
                    title = "Unification Native : iOS, Android et Web",
                    description = "Ne choisissez plus entre performance, portée et coûts de développement. Je conçois des applications unifiées sur un seul code source Kotlin robuste. Vos utilisateurs bénéficient d'une expérience native fluide sur ios, android et n'importe quel navigateur.",
                    ctaText = "Découvrir mon approche KMP →",
                    onCtaClick = { onNavigate(Page.EXPERTISE) },
                    isReversed = false
                ) {
                    ImageCard("home_kmp_visual.png", "Composition KMP")
                }

                // BLOC 2 : Le Produit FSM (Image à gauche)
                FeatureBlock(
                    title = "Solution FSM : Le futur de vos interventions terrain",
                    description = "Fini le papier et les processus déconnectés. Je développe actuellement une solution Field Service Management, pensée pour améliorer l'efficacité opérationnelle sur le terrain.",
                    ctaText = "Voir la roadmap 2027 →",
                    onCtaClick = { onNavigate(Page.FSM) },
                    isReversed = true // <-- Alterne le sens de lecture
                ) {
                    ImageCard("home_logo_fsm.png", "K Native FSM")
                }

                // BLOC 3 : L'Humain & Les Projets (Image à droite)
                FeatureBlock(
                    title = "Le développeur derrière le code",
                    description = "De l'industrie au développement logiciel : un parcours atypique au service de la performance. Aujourd'hui, je conçois des solutions durables avec des technologies modernes comme Kotlin Multiplatform (KMP).",
                    ctaText = "Découvrir mon parcours et mes projets →",
                    onCtaClick = { onNavigate(Page.PORTFOLIO) },
                    isReversed = false
                ) {
                    ImageCard("home_dev_avatar.png", "Avatar")
                }
            }
        }
    }
}