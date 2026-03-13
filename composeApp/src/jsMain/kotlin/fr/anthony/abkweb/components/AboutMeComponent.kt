package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.AboutMeComponentLabels
import fr.anthony.abkweb.CommonLabels
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.H3Custom
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeComponent() {

    var isExpanded by remember { mutableStateOf(false) }

    Div({ classes(*AppColors.textPrimary, *AppColors.themeTransition) }) {

        // --- 1ère Partie (Toujours visible) ---
        H3Custom("font-bold", "text-xl", "mb-3") {
            Text(AboutMeComponentLabels.TITLE)
        }

        P({ classes("text-base", "leading-relaxed") }) {
            Text(AboutMeComponentLabels.DESCRIPTION)
        }

        // --- 2ème Partie (Conditionnelle) ---
        if (isExpanded) {
            Div({ classes("mt-6") }) {
                H3Custom("font-bold", "text-lg", "mb-2") {
                    Text(AboutMeComponentLabels.EXPANDED_TITLE)
                }
                P({ classes("text-base", "leading-relaxed", "mb-4") }) {
                    Text(AboutMeComponentLabels.EXPANDED_DESCRIPTION_A)
                }

                P({ classes("text-base", "leading-relaxed") }) {
                    Text(AboutMeComponentLabels.EXPANDED_DESCRIPTION_B)
                }
            }
        }

        // --- Bouton de bascule ---
        if (!isExpanded) {
            Button({
                classes("text-brandPrimary", "font-bold", "text-left", "hover:underline", "w-max", "mt-2", "pt-4")
                onClick { isExpanded = !isExpanded }
            }) {
                Text(CommonLabels.ACTION_MORE)
            }
        } else {
            Button({
                classes("text-sm", *AppColors.textSecondary, "hover:underline", "pt-4")
                onClick { isExpanded = !isExpanded }
            }) {
                Text(CommonLabels.ACTION_CLOSE)
            }
        }
    }
}