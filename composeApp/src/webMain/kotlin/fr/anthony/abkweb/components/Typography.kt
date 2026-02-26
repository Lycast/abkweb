package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppTypography
import org.jetbrains.compose.web.dom.*

@Composable
fun H1Custom(
    vararg extraClasses: String, // Pour ajouter des marges (mb-6) ou autres au cas par cas
    content: @Composable () -> Unit
) {
    H1({
        classes(*AppTypography.h1, *AppColors.textPrimary, *extraClasses)
    }) {
        content()
    }
}

@Composable
fun BodyText(
    vararg extraClasses: String, // Permet d'ajouter "mb-10" ou "mx-auto" depuis la page
    content: @Composable () -> Unit
) {
    P({
        // On fusionne la typo, la couleur qui switch, et les classes bonus
        classes(*AppTypography.body, *AppColors.textSecondary, *extraClasses)
    }) {
        content()
    }
}

@Composable
fun TextHighlight(
    colorClass: String = "text-cobalt", // Cobalt par défaut, mais modifiable
    content: @Composable () -> Unit
) {
    Span({ classes(colorClass) }) {
        content()
    }
}