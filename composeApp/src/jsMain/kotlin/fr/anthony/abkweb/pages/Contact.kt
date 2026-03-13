package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.PageContactLabels
import fr.anthony.abkweb.components.ContactCard
import fr.anthony.abkweb.data.contacts
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Contact() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-4xl", "mx-auto") }) {

                // --- 1. HEADER CONTACT ---
                H1Custom(AppSpacing.marginM) {
                    Text(PageContactLabels.TITLE_A)
                    TextHighlight(colorClass = AppColors.accent) { Text(PageContactLabels.TITLE_B) }
                }

                BodyText("max-w-2xl", "mx-auto", AppSpacing.marginL) {
                    Text(PageContactLabels.DESCRIPTION)
                }

                // --- 2. GRILLE DE CONTACT ---
                Div({
                    classes("w-full", "grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", *AppSpacing.blockGap)
                }) {
                    contacts.forEach { contact ->
                        ContactCard(
                            icon = contact.icon,
                            title = contact.title,
                            description = contact.description,
                            actionText = contact.actionText,
                            actionLink = contact.actionLink
                        )
                    }
                }
            }
        }
    }
}

