package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.*
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Expertise(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {
        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto", "py-12") }) {

                H1Custom(extraClasses = arrayOf("mb-6")) {
                    Text("Mon Expertise ")
                    TextHighlight(colorClass = AppColors.accent) { Text("KMP") }
                }

                BodyText(extraClasses = arrayOf("mb-10")) {
                    Text("Détails techniques, gestion du hors-ligne et architecture Ktor. Cette page est en cours de rédaction pour vous offrir un contenu détaillé.")
                }

                // Le pont vers la conversion
                Div({ classes("w-fit") }) {
                    SecondaryButton("Discuter de vos besoins techniques →") {
                        onNavigate(Page.CONTACT)
                    }
                }
            }
        }
    }
}