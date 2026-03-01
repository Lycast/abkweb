package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Portfolio(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto") }) {
                H1Custom(AppSpacing.marginM) {
                    Text("Parcours & ")
                    TextHighlight("text-${AppColors.accent}") { Text("Projets") }
                }

                BodyText(AppSpacing.marginL) {
                    Text("De l'industrie au développement logiciel KMP. Cette galerie de projets et mon parcours détaillé sont en cours d'intégration.")
                }

                SecondaryButton("Voir mon profil LinkedIn en attendant →") {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}