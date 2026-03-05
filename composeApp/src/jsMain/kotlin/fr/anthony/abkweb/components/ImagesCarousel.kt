package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppShapes
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun ImagesCarousel(
    images: List<String>,
    onExpand: (Int) -> Unit
) {
    if (images.isEmpty()) {
        Div({ classes("w-full", "h-full", "min-h-[250px]", "flex", "justify-center", "items-center", *AppColors.bgAlt, AppShapes.card, *AppColors.border) }) {
            Text("Images à venir")
        }
        return
    }

    var currentIndex by remember { mutableStateOf(0) }

    Div({
        classes("relative", "w-full", "max-w-2xl", "mx-auto", "group")
    }) {
        ImageCard(
            src = images[currentIndex],
            altText = "Screenshot du projet - Vue ${currentIndex + 1}"
        )

        CarouselArrows(
            isFullScreen = false,
            images = images,
            currentIndex = currentIndex,
            onIndexChange = { newIndex -> currentIndex = newIndex },
            onExpand = onExpand
        )
    }
}