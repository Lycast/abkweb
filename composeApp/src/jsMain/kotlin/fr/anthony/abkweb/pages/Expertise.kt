package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.SecondaryButton
import fr.anthony.abkweb.data.PageExpertiseLabels
import fr.anthony.abkweb.data.expertise
import fr.anthony.abkweb.data.techBadgeList
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun Expertise(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        Div({ classes("container", "mx-auto", "px-6") }) {

            // --- 1. HEADER HERO ---
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-3xl", "mx-auto", "mb-12") }) {
                H1Custom(AppSpacing.marginM) {
                    Text(PageExpertiseLabels.TITLE_A)
                    TextHighlight("text-${AppColors.accent}") { Text(PageExpertiseLabels.TITLE_B) }
                }

                BodyText(AppSpacing.marginL) {
                    Text(PageExpertiseLabels.DESCRIPTION)
                }
            }

            // --- 2. GRILLE D'EXPERTISE (3 colonnes sur Desktop, 1 sur Mobile) ---
            Div({
                classes(
                    "grid", "grid-cols-1", "md:grid-cols-3", "gap-8",
                    "max-w-6xl", "mx-auto", "w-full"
                )
            }) {

                expertise.forEach { expertise ->
                    ExpertiseCard(
                        title = expertise.title,
                        description = expertise.description,
                    )
                }
            }

            // --- 3. SECTION TECHNOLOGIES (Tags visuels) ---
            Div({
                classes(
                    "flex",
                    "flex-col",
                    "items-center",
                    "text-center",
                    "mx-auto",
                    "mt-12",
                    "pt-12",
                    "gap-8"
                )
            }) {
                H2Custom { Text(PageExpertiseLabels.TECH_STACK_LABEL) }

                Div({ classes("flex", "flex-wrap", "justify-center", "gap-2") }) {
                    techBadgeList.forEach { techBadge ->
                        TechBadge(name = techBadge)
                    }
                }
            }

            // --- 4. CTA FINAL ---
            Div({ classes("flex", "flex-col", "items-center", "text-center", "mt-16", "mb-8") }) {
                SecondaryButton(PageExpertiseLabels.LINK_CONTACT) {
                    onNavigate(Page.CONTACT)
                }
            }
        }
    }
}

// --- SOUS-COMPOSANTS PRIVÉS (Spécifiques à la page Expertise) ---
@Composable
private fun ExpertiseCard(title: String, description: String) {
    Div({
        classes(
            *AppColors.border, AppShapes.button, "p-8",
            "flex", "flex-col", "gap-4",
            *AppColors.themeTransition
        )
    }) {
        H3Custom { Text(title) }
        BodyText { Text(description) }
    }
}

@Composable
private fun TechBadge(name: String) {
    Span({
        classes(
            *AppColors.bgAlt, *AppColors.textPrimary, *AppColors.border,
            "px-5", "py-2", AppShapes.button, "text-sm", "font-bold",
            *AppColors.themeTransition
        )
    }) {
        Text(name)
    }
}