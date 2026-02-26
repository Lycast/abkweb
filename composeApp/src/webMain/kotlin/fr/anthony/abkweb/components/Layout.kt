package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

@Composable
fun AppSection(
    isAltBackground: Boolean = false, // Pour alterner entre blanc et gris très clair
    content: @Composable () -> Unit
) {
    val bgClasses = if (isAltBackground) AppColors.bgSection else AppColors.bgMain

    Section({
        classes("py-20", "md:py-32", "w-full", "transition-colors", "duration-500", *bgClasses)
    }) {
        Div({ classes("container", "mx-auto", "px-6") }) {
            content()
        }
    }
}