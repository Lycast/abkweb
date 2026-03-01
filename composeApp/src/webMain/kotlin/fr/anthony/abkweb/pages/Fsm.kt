package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Fsm(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto") }) {
                H1Custom(AppSpacing.marginM) {
                    Text("Solution ")
                    TextHighlight("text-${AppColors.accent}") { Text("FSM") }
                }

                BodyText(AppSpacing.marginL) {
                    Text("L'outil de terrain pensé pour les professionnels. La présentation détaillée de la solution arrive très prochainement.")
                }

                SecondaryButton("Me contacter pour la roadmap 2027 →") {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}