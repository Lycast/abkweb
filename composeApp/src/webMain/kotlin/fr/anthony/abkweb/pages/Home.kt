package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.AppSection
import fr.anthony.abkweb.components.BodyText
import fr.anthony.abkweb.components.H1Custom
import fr.anthony.abkweb.components.PrimaryButton
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.components.ServiceCard
import fr.anthony.abkweb.components.TextHighlight
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.*

@Composable
fun Home(
    onNavigate: (Page) -> Unit
) {
    // On retire le padding-top du main ici car il est déjà géré par le squelette si besoin
    // Mais on garde un conteneur qui centre tout verticalement pour le Hero
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {

        // SECTION HERO
        AppSection {
            Div({ classes("text-center") }) {

                // Un petit badge au-dessus du titre pour le côté "SaaS"
                Span({
                    classes(
                        "inline-block",
                        "px-4", "py-1.5",
                        "mb-6",
                        "text-sm", "font-bold", "tracking-wider",
                        "rounded-full",
                        // COULEURS :
                        "text-brandAccent",      // Texte en Or
                        "bg-brandAccent/10",     // Fond en Or avec 10% d'opacité
                        "border", "border-brandAccent/20" // Optionnel : une petite bordure pour plus de relief
                    )
                }) {
                    Text("DISPONIBLE AVRIL 2026")
                }

                H1Custom(extraClasses = arrayOf("mb-6")) {
                    Text("L'architecture ")
                    TextHighlight(colorClass = AppColors.accent) { Text("Kotlin Multiplatform") }
                    Br()
                    Text("au service de votre métier")
                }

                BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", "mb-10")) {
                    Text("Développeur Fullstack spécialisé KMP. Je conçois des applications mobiles et web unifiées avec un seul code source pour une performance native.")
                }

                Div({ classes("flex", "flex-col", "md:flex-row", "justify-center", "gap-4") }) {

                    // Bouton principal vers l'expertise
                    PrimaryButton("Découvrir mon expertise") {
                        onNavigate(Page.EXPERTISE)
                    }

                    // Bouton secondaire vers le FSM
                    SecondaryButton("Voir la solution FSM →") {
                        onNavigate(Page.FSM)
                    }
                }
            }
        }

        // Dans Home.kt, juste après ton Hero
        AppSection(isAltBackground = true) {
            Div({
                classes("grid", "grid-cols-1", "md:grid-cols-3", "gap-8")
            }) {
                ServiceCard(
                    icon = "📱",
                    title = "Expertise KMP",
                    tag = "MULTI-SUPPORT",
                    description = "Développement d'applications natives iOS et Android avec un seul code source Kotlin. Performance maximale et maintenance réduite."
                )
                ServiceCard(
                    icon = "⚙️",
                    title = "Solution FSM",
                    tag = "MÉTIER",
                    description = "Optimisation de vos interventions terrain. Une solution robuste pensée pour la mobilité et l'efficacité opérationnelle."
                )
                ServiceCard(
                    icon = "🛠️",
                    title = "Audit & Conseil",
                    tag = "QUALITÉ",
                    description = "Analyse de vos architectures existantes et accompagnement vers une transition Kotlin Multiplatform maîtrisée."
                )
            }
        }
    }
}