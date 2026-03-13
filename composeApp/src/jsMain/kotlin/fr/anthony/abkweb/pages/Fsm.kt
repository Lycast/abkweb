package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.PageFSMLabels
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
                    Text(PageFSMLabels.TITLE_A)
                    TextHighlight("text-${AppColors.accent}") { Text(PageFSMLabels.TITLE_B) }
                }

                BodyText(AppSpacing.marginL) {
                    Text(PageFSMLabels.DESCRIPTION)
                }

                SecondaryButton(PageFSMLabels.LINK_CONTACT) {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}