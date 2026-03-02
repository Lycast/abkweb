package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.models.Project
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppTypography
import fr.anthony.abkweb.theme.BodyText
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun FeatureBlockExpanded(
    project: Project,
    onClose: () -> Unit
) {
    Div({ classes("flex", "flex-col", "w-full") }) {

        BodyText("whitespace-pre-wrap") { Text(project.fullDescription) }

        Span({ classes(*AppTypography.body, "font-bold", *AppColors.textPrimary, "mt-4") }) {
            Text("🛠 Stack Technique & Architecture")
        }

        BodyText("whitespace-pre-wrap") { Text(project.techStack) }

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