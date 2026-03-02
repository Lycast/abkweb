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
    vararg extraClasses: String,
    content: @Composable () -> Unit
) {
    P({
        classes(*AppTypography.body, *AppColors.textSecondary, *extraClasses, *AppColors.themeTransition)
    }) {
        content()
    }
}

@Composable
fun TextHighlight(
    colorClass: String = "text-cobalt",
    content: @Composable () -> Unit
) {
    Span({ classes(colorClass) }) {
        content()
    }
}