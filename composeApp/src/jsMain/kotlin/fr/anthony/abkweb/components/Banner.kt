package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun Banner() {

    // Bannière Logo avec animation d'entrée
    Div({
        // On centre le contenu, on donne une marge, et on appelle l'animation
        classes("w-full", "flex", "justify-center", *AppColors.bgCard, "pt-12", "pb-6", "animate-fade-in-up")
    }) {
        Img(src = "/logo_abknative.webp", attrs = {
            classes("h-32", "md:h-48", "w-auto", "object-contain")
            alt("Logo ABK Native Complet")
        })
    }
}