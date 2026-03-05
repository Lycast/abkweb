package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppShapes
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun ImageCard(
    src: String,
    altText: String
) {
    Div({
        classes(
            "w-full", "max-w-2xl", "md:h-[400px]", "h-[300px]",
            "flex", "justify-center", "items-center",
            AppShapes.card,
            "p-4",
            *AppColors.border,
            *AppColors.themeTransition
        )
    }) {
        Img(src = src, attrs = {
            classes("w-full", "h-full", "object-contain")
            alt(altText)
        })
    }
}