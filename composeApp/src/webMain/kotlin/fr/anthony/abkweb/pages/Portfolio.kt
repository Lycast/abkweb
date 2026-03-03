package fr.anthony.abkweb.pages

import androidx.compose.runtime.*
import fr.anthony.abkweb.components.AboutMeComponent
import fr.anthony.abkweb.components.FeatureBlock
import fr.anthony.abkweb.components.FeatureBlockExpanded
import fr.anthony.abkweb.components.ProjectCarousel
import fr.anthony.abkweb.data.myProjectsList
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppSpacing
import fr.anthony.abkweb.theme.H2Custom
import fr.anthony.abkweb.theme.TextHighlight
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.w3c.dom.*

@Composable
fun Portfolio(onNavigate: (Page) -> Unit) {
    var expandedProjectId by remember { mutableStateOf<String?>(null) }

    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        Div({ classes("container", "mx-auto", "px-6") }) {

            H2Custom("text-center", *AppSpacing.sectionTight) {
                Text("Mon ")
                TextHighlight("text-${AppColors.accent}") { Text("Parcours") }
            }

            // 1. Ton composant "A propos de moi"
            AboutMeComponent()

            // 2. Le titre des réalisations
            H2Custom(*AppSpacing.sectionTight, "text-center") {
                Text("Mes ")
                TextHighlight("text-${AppColors.accent}") { Text("Réalisations") }
            }

            // 3. La liste des projets générée dynamiquement
            Div({ classes("flex", "flex-col", "gap-8", "animate-fade-in-up") }) {
                myProjectsList.forEachIndexed { index, project ->
                    Div({ id(project.id) }) {

                        val handleToggle = {
                            val isOpening = expandedProjectId != project.id
                            expandedProjectId = if (isOpening) project.id else null

                            // Si on ferme, on recentre la vue
                            if (!isOpening) {
                                window.setTimeout({
                                    document.getElementById(project.id)?.scrollIntoView(
                                        arg = ScrollIntoViewOptions(
                                            behavior = ScrollBehavior.SMOOTH,
                                            block = ScrollLogicalPosition.START
                                        )
                                    )
                                }, 100)
                            }
                        }

                        FeatureBlock(
                            title = project.title,
                            description = project.shortDescription,
                            ctaText = "",
                            onCtaClick = {},
                            isReversed = index % 2 != 0,
                            isExpandable = true,
                            isExpanded = expandedProjectId == project.id,
                            onToggle = handleToggle,
                            visualContent = {
                                ProjectCarousel(images = project.images)
                            },
                            expandedContent = {
                                FeatureBlockExpanded(
                                    project = project,
                                    onClose = handleToggle
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}