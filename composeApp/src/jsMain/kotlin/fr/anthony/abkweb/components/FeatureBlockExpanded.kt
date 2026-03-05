package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.model.Project
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.BodyText
import fr.anthony.abkweb.theme.ParsedText
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun FeatureBlockExpanded(
    project: Project,
    onClose: () -> Unit
) {
    Div({ classes("flex", "flex-col", "w-full") }) {

        // FullDescription
        BodyText("whitespace-pre-wrap") { ParsedText(project.fullDescription) }

        // Tech Stack
        BodyText("whitespace-pre-wrap") { ParsedText(project.techStack) }

        // Actions de bas de projet
        Div({ classes("flex", "flex-col", "sm:flex-row", "justify-between", "items-center", "mt-8", "gap-4") }) {
            if (project.githubUrl != null) {
                SecondaryButton("Voir le code source →") {
                    window.open(project.githubUrl, "_blank")
                }
            } else {
                Div() {}
            }

            Button({
                classes("text-sm", *AppColors.textSecondary, "hover:underline")
                onClick { onClose() }
            }) {
                Text("↑ Refermer")
            }
        }
    }
}