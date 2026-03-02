package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppShapes
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img
import org.jetbrains.compose.web.dom.Text

@Composable
fun ProjectCarousel(images: List<String>) {
    if (images.isEmpty()) {
        Div({
            classes(
                "w-full", "h-full", "min-h-[250px]",
                "flex", "justify-center", "items-center",
                *AppColors.bgAlt, AppShapes.card, *AppColors.border
            )
        }) {
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

        if (images.size > 1) {
            // Flèche Gauche
            Button({
                classes(
                    "absolute", "left-2", "top-1/2", "-translate-y-1/2",
                    "bg-black/40", "hover:bg-black/70", "text-white",
                    "rounded-full", "p-2",
                    "transition-all", "duration-200", "ease-in-out",
                    "opacity-20", "group-hover:opacity-100",
                    "flex", "items-center", "justify-center" // Centrage de l'icône
                )
                onClick {
                    currentIndex = if (currentIndex == 0) images.size - 1 else currentIndex - 1
                }
            }) {
                Img(src = "icon_chevron_left.svg", attrs = {
                    classes("w-5", "h-5", "dark:invert")
                    alt("Précédent")
                })
            }

            // Flèche Droite
            Button({
                classes(
                    "absolute", "right-2", "top-1/2", "-translate-y-1/2",
                    "bg-black/40", "hover:bg-black/70", "text-white",
                    "rounded-full", "p-2",
                    "transition-all", "duration-200", "ease-in-out",
                    "opacity-20", "group-hover:opacity-100",
                    "flex", "items-center", "justify-center"
                )
                onClick {
                    currentIndex = if (currentIndex == images.size - 1) 0 else currentIndex + 1
                }
            }) {
                Img(src = "icon_chevron_right.svg", attrs = {
                    classes("w-5", "h-5", "dark:invert")
                    alt("Suivant")
                })
            }

            // Indicateurs en bas
            Div({ classes("absolute", "bottom-4", "left-1/2", "-translate-x-1/2", "flex", "gap-2") }) {
                images.forEachIndexed { index, _ ->
                    Div({
                        classes("h-2", "rounded-full",  *AppColors.themeTransition)
                        if (index == currentIndex) {
                            classes("bg-brandPrimary", "w-4")
                        } else {
                            classes("bg-gray-400", "w-2")
                        }
                    }) {}
                }
            }
        }
    }
}