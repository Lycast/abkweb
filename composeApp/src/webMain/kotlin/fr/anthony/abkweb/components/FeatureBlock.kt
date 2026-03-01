package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppSpacing
import fr.anthony.abkweb.theme.AppTypography
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun FeatureBlock(
    title: String,
    description: String,
    ctaText: String,
    isReversed: Boolean = false,
    onCtaClick: () -> Unit,
    visualContent: @Composable () -> Unit
) {
    val layoutDirection = if (isReversed) "md:flex-row-reverse" else "md:flex-row"

    Div({
        classes(
            "flex", "flex-col", layoutDirection, "items-center",
            *AppSpacing.blockGap, *AppSpacing.sectionTight
        )
    }) {
        // --- ZONE TEXTE ---
        Div({ classes("w-full", "md:w-1/2", "flex", "flex-col", AppSpacing.stack) }) {
            H2({
                classes(*AppTypography.h2, *AppColors.textPrimary)
            }) {
                Text(title)
            }

            P({
                classes(*AppTypography.body, *AppColors.textSecondary)
            }) {
                Text(description)
            }

            // --- INTÉGRATION DU SECONDARY BUTTON ---
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