package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Expertise(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto") }) {
                H1Custom(AppSpacing.marginM) {
                    Text("Mon Expertise ")
                    TextHighlight("text-${AppColors.accent}") { Text("KMP") }
                }

                BodyText(AppSpacing.marginL) {
                    Text("Détails techniques, gestion du hors-ligne et architecture Ktor. Cette page est en cours de rédaction pour vous offrir un contenu détaillé.")
                }

                SecondaryButton("Discuter de vos besoins techniques →") {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}