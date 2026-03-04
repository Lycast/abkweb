package fr.anthony.abkweb.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun ParsedText(text: String) {
    val parts = text.split("**")

    parts.forEachIndexed { index, part ->
        if (index % 2 == 0) {
            // Les index pairs (0, 2, 4...) sont le texte normal
            Text(part)
        } else {
            // Les index impairs (1, 3, 5...) sont ce qui se trouvait entre deux "**"
            Span({ classes("font-bold", *AppColors.textPrimary) }) {
                Text(part)
            }
        }
    }
}