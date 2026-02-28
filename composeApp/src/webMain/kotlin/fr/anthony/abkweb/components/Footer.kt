package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterComponent() {
    Footer({
        // On utilise bg-black pour l'OLED ou un gris très sombre pour le relief
        classes("bg-black", "border-t", "border-slate-800", "py-12", "mt-auto", "w-full")
    }) {
        Div({ classes("container", "mx-auto", "px-6") }) {

            Div({ classes("grid", "grid-cols-1", "md:grid-cols-3", "gap-12", "mb-8") }) {

                // 1. Identité
                Div({ classes("flex", "flex-col", "space-y-4") }) {
                    Span({ classes("text-2xl", "font-heading", "font-bold", "text-brandPrimary") }) {
                        Text("ABK Native")
                    }
                    P({ classes("text-sm", "leading-relaxed", "text-slate-400") }) {
                        Text("L'unification native au service de votre entreprise. Kotlin Multiplatform, du serveur à l'interface.")
                    }
                }

                // 2. Navigation
                Div({ classes("flex", "flex-col", "space-y-3") }) {
                    H3({ classes("text-white", "font-bold", "mb-2", "text-sm", "uppercase", "tracking-wider") }) {
                        Text("Navigation")
                    }
                    FooterLink("Expertise KMP")
                    FooterLink("Solution FSM")
                    FooterLink("Me contacter")
                }

                // 3. Réseaux & Légal
                Div({ classes("flex", "flex-col", "space-y-3") }) {
                    H3({ classes("text-white", "font-bold", "mb-2", "text-sm", "uppercase", "tracking-wider") }) {
                        Text("Réseaux sociaux")
                    }
                    FooterLink("LinkedIn")
                    FooterLink("GitHub")

                    Div({ classes("mt-4") }) {
                        FooterLink("Mentions légales")
                    }
                }
            }

            Hr({ classes("border-slate-800", "my-8") })

            // Copyright
            Div({ classes("text-center", "text-xs", "text-slate-500", "uppercase", "tracking-widest") }) {
                Text("© 2026 ABK Native. Designé pour l'efficacité OLED.")
            }
        }
    }
}

/**
 * Petit atome local pour les liens du footer afin d'éviter la répétition
 */
@Composable
private fun FooterLink(text: String, href: String = "#") {
    A(href = href, {
        classes(
            "text-slate-400",
            "hover:text-brandPrimary",
            "transition-colors",
            "text-sm",
            "duration-300"
        )
    }) {
        Text(text)
    }
}