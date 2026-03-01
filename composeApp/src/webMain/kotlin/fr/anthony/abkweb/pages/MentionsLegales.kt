package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MentionsLegales() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            // "max-w-3xl" est parfait pour la lecture (environ 80 caractères par ligne)
            Div({ classes("max-w-3xl", "mx-auto", "text-left") }) {

                H1Custom("text-center", AppSpacing.marginL) {
                    Text("Mentions Légales")
                }

                // Utilisation de AppSpacing.stack pour l'espace entre les blocs
                Div({ classes("flex", "flex-col", AppSpacing.stack, *AppColors.textSecondary) }) {

                    LegalBlock("Éditeur du site") {
                        P { Text("ABK Native (Anthony Brenon)") }
                        P { Text("Micro-entreprise — SIRET : En cours d'immatriculation") }
                        P { Text("Domiciliation : Cholet, France") }
                        P { Text("Email de contact : contact@abknative.fr") }
                    }

                    LegalBlock("Hébergement") {
                        P { Text("GitHub Pages (GitHub, Inc.)") }
                        P { Text("88 Colin P Kelly Jr St, San Francisco, CA 94107, États-Unis") }
                    }

                    LegalBlock("Propriété intellectuelle") {
                        P { Text("Toute reproduction ou représentation, intégrale ou partielle, du site ou de ses éléments est interdite sans autorisation préalable.") }
                    }
                }
            }
        }
    }
}

@Composable
private fun LegalBlock(title: String, content: @Composable () -> Unit) {
    Div({ classes("flex", "flex-col", "gap-3") }) {
        H2({ classes(*AppTypography.h3, *AppColors.textPrimary) }) {
            Text(title)
        }
        // Utilisation de bodySmall pour le texte juridique (plus compact et pro)
        Div({ classes(*AppTypography.bodySmall) }) {
            content()
        }
    }
}