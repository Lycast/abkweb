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

        var currentPage by remember { mutableStateOf(parsePageFromUrl(window.location.pathname)) }

        DisposableEffect(Unit) {
            val onPopState = { _: Any ->
                currentPage = parsePageFromUrl(window.location.pathname)
            }
            window.addEventListener("popstate", onPopState)
            onDispose {
                window.removeEventListener("popstate", onPopState)
            }
        }

        val navigateTo: (Page) -> Unit = { newPage ->
            if (currentPage != newPage) {
                currentPage = newPage
                window.history.pushState(null, "", newPage.route)
                window.scrollTo(0.0, 0.0)
            }
        }

        Div({ classes("min-h-screen", "flex", "flex-col", "w-full", *AppColors.bgMain, *AppColors.themeTransition) }) {

            HeaderComponent(
                currentPage = currentPage,
                onNavigate = navigateTo
            )

            Div({
                classes(
                    "container", "mx-auto", "px-6", "flex", "justify-end",
                    "sticky", "top-[80px]", "z-40", "pointer-events-none"
                )
            }) {
                Div({ classes("pointer-events-auto", "md:pt-8") }) {
                    ThemeToggleButton()
                }
            }

            Main({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
                PageRouter(
                    currentPage = currentPage,
                    onNavigate = navigateTo
                )
            }

            FooterComponent(onNavigate = navigateTo)
        }
    }
}
