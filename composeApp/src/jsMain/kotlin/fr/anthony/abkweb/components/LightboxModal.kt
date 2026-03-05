package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun LightboxModal(
    images: List<String>,
    initialIndex: Int,
    onClose: () -> Unit
) {

    var currentIndex by remember { mutableStateOf(initialIndex) }

    Div({
        classes("fixed", "inset-0", "z-[100]", *AppColors.bgMain90, "flex", "justify-center", "items-center", "group")
    }) {

        // L'image en grand
        Img(src = images[currentIndex], attrs = {
            classes("max-w-[90%]", "max-h-[90vh]", "object-contain")
        })

        CarouselArrows(
            isFullScreen = true,
            images = images,
            currentIndex = currentIndex,
            onIndexChange = { newIndex -> currentIndex = newIndex },
            onClose = onClose
        )
    }
}