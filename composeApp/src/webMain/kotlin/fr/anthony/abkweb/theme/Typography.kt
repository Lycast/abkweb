package fr.anthony.abkweb.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.*

@Composable
fun H1Custom(
    vararg extraClasses: String,
    content: @Composable () -> Unit
) {
    H1({
        classes(*AppTypography.h1, *AppColors.textPrimary, *extraClasses, *AppColors.themeTransition)
    }) {
        content()
    }
}

@Composable
fun H2Custom(
    vararg extraClasses: String,
    content: @Composable () -> Unit
) {
    H2({
        // On utilise ici AppTypography.h2 défini dans ton thème
        classes(*AppTypography.h2, *AppColors.textPrimary, *extraClasses, *AppColors.themeTransition)
    }) {
        content()
    }
}

@Composable
fun H3Custom(
    vararg extraClasses: String,
    content: @Composable () -> Unit
) {
    H3({
        classes(*AppTypography.h3, *AppColors.textPrimary, *extraClasses, *AppColors.themeTransition)
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
        classes(*AppTypography.body, *AppColors.textSecondary, *extraClasses, *AppColors.themeTransition)
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