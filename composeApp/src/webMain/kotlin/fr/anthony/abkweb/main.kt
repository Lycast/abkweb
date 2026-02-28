package fr.anthony.abkweb

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import fr.anthony.abkweb.components.FooterComponent
import fr.anthony.abkweb.components.HeaderComponent
import fr.anthony.abkweb.pages.*
import fr.anthony.abkweb.router.Page
import kotlinx.browser.window
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Main
import org.jetbrains.compose.web.renderComposable

fun main() {
    renderComposable(rootElementId = "root") {

        // L'état global de la navigation
        var currentPage by remember { mutableStateOf(Page.HOME) }

        // Déclaration propre de la fonction de navigation pour éviter la répétition
        val navigateTo: (Page) -> Unit = { newPage ->
            currentPage = newPage
            window.scrollTo(0.0, 0.0)
        }

        // LE SQUELETTE DE L'APPLICATION
        Div({ classes("min-h-screen", "flex", "flex-col", "w-full") }) {

            // 1. LE HEADER FIXE
            HeaderComponent(
                currentPage = currentPage,
                onNavigate = navigateTo
            )

            // 2. Le conteneur principal du routeur s'assure de pousser le footer en bas
            Main({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
                when (currentPage) {
                    Page.HOME -> Home(onNavigate = navigateTo)
                    Page.EXPERTISE -> Expertise(onNavigate = navigateTo)
                    Page.FSM -> Fsm(onNavigate = navigateTo)
                    Page.PORTFOLIO -> Portfolio(onNavigate = navigateTo)

                    // Ces pages n'ont pas de boutons de redirection interne, elles ne prennent donc pas le paramètre
                    Page.CONTACT -> Contact()
                    Page.LEGAL -> MentionsLegales()
                }
            }

            // 3. Le FOOTER (Désormais câblé)
            FooterComponent(onNavigate = navigateTo)
        }
    }
}