package fr.anthony.abkweb.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span

@Composable
fun H1Custom(
    vararg extraClasses: String,
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