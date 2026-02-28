package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.*
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Portfolio(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {
        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto", "py-12") }) {

                H1Custom(extraClasses = arrayOf("mb-6")) {
                    Text("Parcours & ")
                    TextHighlight(colorClass = AppColors.accent) { Text("Projets") }
                }

                BodyText(extraClasses = arrayOf("mb-10")) {
                    Text("De l'industrie au développement logiciel KMP. Cette galerie de projets et mon parcours détaillé sont en cours d'intégration.")
                }

                // Le pont vers la conversion
                Div({ classes("w-fit") }) {
                    SecondaryButton("Voir mon profil LinkedIn en attendant →") {
                        onNavigate(Page.CONTACT)
                    }
                }
            }
        }
    }
}