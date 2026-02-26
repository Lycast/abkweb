package fr.anthony.abkweb

import androidx.compose.runtime.*
import fr.anthony.abkweb.components.FooterComponent
import fr.anthony.abkweb.components.HeaderComponent
import fr.anthony.abkweb.pages.*
import fr.anthony.abkweb.router.Page
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {

        // L'état global de la navigation
        var currentPage by remember { mutableStateOf(Page.HOME) }

        // LE SQUELETTE DE L'APPLICATION
        Div({ classes("min-h-screen", "flex", "flex-col", "w-full") }) {

            // 1. LE HEADER FIXE
            HeaderComponent(
                currentPage = currentPage,
                onNavigate = { newPage -> currentPage = newPage }
            )

            // 2. Le conteneur principal du routeur s'assure de pousser le footer en bas
            Main({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
                when (currentPage) {
                    Page.HOME -> Home(onNavigate = { newPage -> currentPage = newPage })
                    Page.EXPERTISE -> Expertise()
                    Page.FSM -> Fsm()
                    Page.CONTACT -> Contact()
                }
            }

            // 3. Le FOOTER
            FooterComponent()
        }
    }
}