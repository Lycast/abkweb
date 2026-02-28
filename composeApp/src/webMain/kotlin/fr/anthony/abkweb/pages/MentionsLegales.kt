package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.AppSection
import fr.anthony.abkweb.components.H1Custom
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MentionsLegales() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {
        AppSection {
            Div({ classes("max-w-3xl", "mx-auto", "py-12", "text-left") }) {

                H1Custom(extraClasses = arrayOf("mb-12", "text-center")) {
                    Text("Mentions Légales")
                }

                Div({ classes("flex", "flex-col", "gap-8", *AppColors.textSecondary) }) {

                    // Rubrique 1 : Éditeur (fusionné)
                    LegalBlock("Éditeur du site") {
                        P { Text("ABK Native (Anthony Brenon)") }
                        P { Text("Micro-entreprise — SIRET : En cours d'immatriculation") }
                        P { Text("Domiciliation : Cholet, France") }
                        P { Text("Email de contact : contact@abknative.fr") }
                    }

                    // Rubrique 2 : Hébergeur (GitHub)
                    LegalBlock("Hébergement") {
                        P { Text("GitHub Pages (GitHub, Inc.)") }
                        P { Text("88 Colin P Kelly Jr St, San Francisco, CA 94107, États-Unis") }
                    }

                    // Rubrique 3 : Propriété intellectuelle
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
    Div({ classes("flex", "flex-col", "gap-2") }) {
        H2({ classes("text-xl", "font-bold", "mb-2", *AppColors.textPrimary) }) {
            Text(title)
        }
        Div({ classes("text-base", "leading-relaxed") }) {
            content()
        }
    }
}