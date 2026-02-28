package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FeatureBlock(
    title: String,
    description: String,
    ctaText: String, // Tu pourras lui passer "Découvrir mon approche KMP →" directement
    isReversed: Boolean = false,
    onCtaClick: () -> Unit,
    visualContent: @Composable () -> Unit
) {
    val layoutDirection = if (isReversed) "md:flex-row-reverse" else "md:flex-row"

    Div({
        classes(
            "flex", "flex-col", layoutDirection, "gap-12", "md:gap-20",
            "items-center", "py-20",
            "border-b", "border-slate-800/50", "last:border-0"
        )
    }) {
        // --- ZONE TEXTE ---
        Div({ classes("w-full", "md:w-1/2", "flex", "flex-col", "gap-6") }) {
            H2({
                classes("text-3xl", "md:text-4xl", "font-heading", "font-bold", *AppColors.textPrimary)
            }) {
                Text(title)
            }

            P({
                classes("text-lg", "leading-relaxed", *AppColors.textSecondary)
            }) {
                Text(description)
            }

            // --- INTÉGRATION DU SECONDARY BUTTON ---
            // Le w-fit empêche le bouton de s'étirer sur toute la largeur de la colonne
            Div({ classes("w-fit", "mt-4") }) {
                SecondaryButton(
                    text = ctaText,
                    onClick = onCtaClick
                )
            }
        }

        // --- ZONE VISUELLE ---
        Div({ classes("w-full", "md:w-1/2", "flex", "justify-center") }) {
            visualContent()
        }
    }
}