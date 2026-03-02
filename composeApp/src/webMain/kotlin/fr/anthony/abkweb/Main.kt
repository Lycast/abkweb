package fr.anthony.abkweb

import androidx.compose.runtime.*
import fr.anthony.abkweb.components.FooterComponent
import fr.anthony.abkweb.components.HeaderComponent
import fr.anthony.abkweb.components.ThemeToggleButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.router.PageRouter
import fr.anthony.abkweb.router.parsePageFromUrl
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.ThemeManager
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposable

fun main() {

    ThemeManager.init()

    renderComposable(rootElementId = "root") {

        // L'état global de la navigation synchronisé avec l'URL
        var currentPage by remember { mutableStateOf(parsePageFromUrl(window.location.pathname)) }

        // Gestion du bouton Précédent/Suivant du navigateur (PopState)
        DisposableEffect(Unit) {
            val onPopState = { _: Any ->
                currentPage = parsePageFromUrl(window.location.pathname)
            }
            window.addEventListener("popstate", onPopState)
            onDispose {
                window.removeEventListener("popstate", onPopState)
            }
        }

        // Déclaration propre de la fonction de navigation pour éviter la répétition
        val navigateTo: (Page) -> Unit = { newPage ->
            if (currentPage != newPage) {
                currentPage = newPage
                window.history.pushState(null, "", newPage.route)
                window.scrollTo(0.0, 0.0)
            }
        }

        // LE SQUELETTE DE L'APPLICATION
        Div({ classes("min-h-screen", "flex", "flex-col", "w-full", *AppColors.bgMain, *AppColors.themeTransition) }) {

            // 1. LE HEADER FIXE
            HeaderComponent(
                currentPage = currentPage,
                onNavigate = navigateTo
            )

            // 2. ZONE DU BOUTON
            Div({
                classes(
                    "container", "mx-auto", "px-6", "flex", "justify-end",
                    "sticky", "top-[88px]", "z-40", "pointer-events-none"
                )
            }) {
                // On réactive les clics uniquement sur le bouton
                Div({ classes("pointer-events-auto", "py-6", "px-2") }) {
                    ThemeToggleButton()
                }
            }

            // 3. LE CONTENEUR PRINCIPAL
            Main({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
                PageRouter(
                    currentPage = currentPage,
                    onNavigate = navigateTo
                )
            }

            // 4. LE FOOTER
            FooterComponent(onNavigate = navigateTo)
        }
    }
}
