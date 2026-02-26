package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterComponent() {
    Footer({
        // "mt-auto" s'assure que le footer est toujours poussé tout en bas,
        // même si la page a très peu de contenu.
        classes("bg-slate-900", "text-slate-300", "py-12", "mt-auto", "w-full")
    }) {
        Div({ classes("container", "mx-auto", "px-6") }) {

            // Grille CSS : 1 colonne sur mobile, 3 colonnes sur PC (md:grid-cols-3)
            Div({ classes("grid", "grid-cols-1", "md:grid-cols-3", "gap-8", "mb-8") }) {

                // Colonne 1 : Marque
                Div({ classes("flex", "flex-col", "space-y-4") }) {

                    // TODO: Remplacer ce Span par la balise Img() de ton logo
                    Span({ classes("text-2xl", "font-heading", "font-bold", "text-white") }) {
                        Text("ABK Native")
                    }

                    P({ classes("text-sm", "leading-relaxed") }) {
                        Text("L'unification native au service de votre entreprise. Kotlin Multiplatform, du serveur à l'interface.")
                    }
                }

                // Colonne 2 : Liens Rapides
                Div({ classes("flex", "flex-col", "space-y-2") }) {
                    H3({ classes("text-white", "font-bold", "mb-2") }) { Text("Navigation") }
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm") }) { Text("Expertise KMP") }
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm") }) { Text("Solution FSM") }
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm") }) { Text("Me contacter") }
                }

                // Colonne 3 : Réseaux & Légal
                Div({ classes("flex", "flex-col", "space-y-2") }) {
                    H3({ classes("text-white", "font-bold", "mb-2") }) { Text("Réseaux sociaux") }

                    // TODO: Mettre tes vrais liens (ex: href="https://linkedin.com/in/tonprofil")
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm") }) { Text("LinkedIn") }
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm") }) { Text("GitHub") }

                    // TODO: Créer une page de mentions légales (obligatoire en tant que freelance)
                    A(href = "#", { classes("hover:text-emerald", "transition-colors", "text-sm", "mt-4") }) { Text("Mentions légales") }
                }
            }

            // Ligne de séparation subtile
            Hr({ classes("border-slate-700", "my-6") })

            // Copyright avec l'année de ton lancement
            Div({ classes("text-center", "text-sm", "text-slate-500") }) {
                Text("© 2026 ABK Native. Tous droits réservés.")
            }
        }
    }
}