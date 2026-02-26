package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.BodyText
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.*

@Composable
fun Expertise() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain, "transition-colors", "duration-500") }) {
        Div({ classes("container", "mx-auto", "px-6", "flex", "flex-col", "items-center", "text-center") }) {

            H1({ classes("text-4xl", "font-heading", "text-cobalt", "mb-6") }) {
                Text("Mon Expertise KMP")
            }

            BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", "mb-10")) {
                Text("Détails techniques, gestion du hors-ligne et architecture Ktor. Contenu en construction.")
            }
        }
    }
}