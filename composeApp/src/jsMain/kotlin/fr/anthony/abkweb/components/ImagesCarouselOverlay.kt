package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun CarouselArrows(
    isFullScreen: Boolean,
    images: List<String>,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    onExpand: (Int) -> Unit = {},
    onClose: () -> Unit = {}
) {
    if(isFullScreen) {
        // Bouton Réduire
        Button({
            classes(
                "absolute", "top-6", "right-6",
                "bg-black/10", "dark:bg-white/10", "hover:bg-black/50", "hover:dark:bg-white/50",
                "p-3", "rounded-md",
                "transition-all", "duration-200"
            )
            onClick { onClose() }
        }) {
            Img(src = "icon_minimise.svg", attrs = {
                classes("w-6", "h-6", "dark:invert")
                alt("Réduire l'image")
            })
        }
    } else {
        // Bouton Agrandir
        Button({
            classes(
                "absolute", "top-2", "right-2",
                "bg-black/10", "dark:bg-white/10", "hover:bg-black/50", "hover:dark:bg-white/50",
                "p-2", "rounded-md",
                "transition-all", "duration-200",
                "opacity-0", "group-hover:opacity-100"
            )
            onClick { onExpand(currentIndex) }
        }) {
            Img(src = "icon_expend.svg", attrs = {
                classes("w-5", "h-5", "dark:invert")
                alt("Agrandir l'image")
            })
        }
    }

    if (images.size <= 1) return

    // Flèche Gauche
    Button({
        classes(
            "absolute", "left-2", "top-1/2", "-translate-y-1/2",
            "bg-black/10", "dark:bg-white/10", "hover:bg-black/50", "hover:dark:bg-white/50",
            "rounded-full", "p-2",
            "transition-all", "duration-200", "ease-in-out",
            "opacity-20", "group-hover:opacity-100",
            "flex", "items-center", "justify-center"
        )
        onClick {
            it.stopPropagation()
            val prevIndex = if (currentIndex == 0) images.size - 1 else currentIndex - 1
            onIndexChange(prevIndex)
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
            "bg-black/10", "dark:bg-white/10", "hover:bg-black/50", "hover:dark:bg-white/50",
            "rounded-full", "p-2",
            "transition-all", "duration-200", "ease-in-out",
            "opacity-20", "group-hover:opacity-100",
            "flex", "items-center", "justify-center"
        )
        onClick {
            it.stopPropagation()
            val nextIndex = if (currentIndex == images.size - 1) 0 else currentIndex + 1
            onIndexChange(nextIndex)
        }
    }) {
        Img(src = "icon_chevron_right.svg", attrs = {
            classes("w-5", "h-5", "dark:invert")
            alt("Suivant")
        })
    }

    // Indicateurs en bas
    Div({ classes("absolute", "bottom-1.5", "left-1/2", "-translate-x-1/2", "flex", "gap-2") }) {
        images.forEachIndexed { index, _ ->
            Div({
                classes("h-2", "rounded-full", *AppColors.themeTransition)
                if (index == currentIndex) {
                    classes("bg-brandPrimary", "w-4")
                } else {
                    classes("bg-gray-400", "w-2", "cursor-pointer")
                }

                onClick {
                    it.stopPropagation()
                    onIndexChange(index)
                }
            }) {}
        }
    }
}