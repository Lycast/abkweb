package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Img

@Composable
fun Banner() {

    // Bannière Logo avec animation d'entrée
    Div({
        // On centre le contenu, on donne une marge, et on appelle l'animation
        classes("w-full", "bg-slate-50", "dark:bg-slate-950", "flex", "justify-center", "pt-12", "pb-6", "animate-fade-in-up")
    }) {
        // Si tu as un fichier logo complet avec le texte pour cette bannière
        Img(src = "/logo_abknative_dark.png", attrs = {
            // Une hauteur généreuse (h-24 ou h-32), cachée en mode clair si nécessaire
            classes("h-48", "w-auto", "object-contain", "hidden", "dark:block")
            alt("Logo ABK Native Complet")
        })

        Img(src = "/logo_abknative_light.png", attrs = {
            classes("h-48", "w-auto", "object-contain", "dark:hidden")
            alt("Logo ABK Native Complet")
        })
    }
}