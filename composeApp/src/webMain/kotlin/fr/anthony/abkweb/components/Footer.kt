package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterComponent(onNavigate: (Page) -> Unit) { // <-- Ajout vital du routeur
    Footer({
        // Utilisation de bgMain pour suivre le thème, avec la bordure subtile
        classes(
            "border-t", "border-slate-800/50", "py-12", "mt-auto", "w-full",
            *AppColors.bgMain
        )
    }) {
        Div({ classes("container", "mx-auto", "px-6", "max-w-6xl") }) {

            Div({ classes("grid", "grid-cols-1", "md:grid-cols-3", "gap-12", "mb-8") }) {

                // 1. Identité
                Div({ classes("flex", "flex-col", "gap-4") }) {
                    Span({ classes("text-2xl", "font-heading", "font-bold", "text-brandPrimary", "dark:text-brandSecondary") }) {
                        Text("ABK Native")
                    }
                    P({ classes("text-sm", "leading-relaxed", *AppColors.textSecondary) }) {
                        Text("L'unification native au service de votre entreprise. Kotlin Multiplatform, du serveur à l'interface.")
                    }
                }

                // 2. Navigation
                Div({ classes("flex", "flex-col", "gap-3") }) {
                    H3({ classes("font-bold", "mb-2", "text-sm", "uppercase", "tracking-wider", *AppColors.textPrimary) }) {
                        Text("Navigation")
                    }
                    FooterInternalLink("Expertise KMP", Page.EXPERTISE, onNavigate)
                    FooterInternalLink("Solution FSM", Page.FSM, onNavigate)
                    FooterInternalLink("Me contacter", Page.CONTACT, onNavigate)
                }

                // 3. Réseaux & Légal
                Div({ classes("flex", "flex-col", "gap-3") }) {
                    H3({ classes("font-bold", "mb-2", "text-sm", "uppercase", "tracking-wider", *AppColors.textPrimary) }) {
                        Text("Réseaux sociaux")
                    }
                    FooterExternalLink("LinkedIn", "https://www.linkedin.com/in/anthony-brenon-a7761b213")
                    FooterExternalLink("GitHub", "https://github.com/Lycast")

                    Div({ classes("mt-4", "flex", "flex-col", "gap-3") }) {
                        FooterInternalLink("Mentions légales", Page.LEGAL, onNavigate)
                    }
                }
            }

            Hr({ classes("border-slate-200", "dark:border-slate-800", "my-8") })

            // Copyright
            Div({ classes("text-center", "text-xs", "uppercase", "tracking-widest", *AppColors.textSecondary) }) {
                Text("© 2026 ABK Native. Propulsé par Kotlin. Construit avec Compose HTML.")
            }
        }
    }
}

/**
 * Lien interne branché sur le Routeur (Ne recharge pas la page)
 */
@Composable
private fun FooterInternalLink(text: String, page: Page, onNavigate: (Page) -> Unit) {
    A(href = "#", attrs = {
        classes("hover:text-brandPrimary", "transition-colors", "text-sm", "duration-300", "w-fit", *AppColors.textSecondary)
        onClick {
            it.preventDefault()
            onNavigate(page)
        }
    }) {
        Text(text)
    }
}

/**
 * Lien externe classique (Ouvre un nouvel onglet)
 */
@Composable
private fun FooterExternalLink(text: String, url: String) {
    A(href = url, attrs = {
        classes("hover:text-brandPrimary", "transition-colors", "text-sm", "duration-300", "w-fit", *AppColors.textSecondary)
        target(ATarget.Blank)
    }) {
        Text(text)
    }
}