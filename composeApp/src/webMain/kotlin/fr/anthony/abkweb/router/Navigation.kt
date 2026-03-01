package fr.anthony.abkweb.router

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.pages.*

enum class Page(val route: String) {
    HOME("/"),
    EXPERTISE("/expertise"),
    FSM("/fsm"),
    CONTACT("/contact"),
    PORTFOLIO("/portfolio"),
    LEGAL("/legal")
}

// Le Router est maintenant "Stateless" (sans état).
// Il reçoit l'état depuis le main, ce qui permet au Header/Footer d'y avoir accès aussi.
@Composable
fun PageRouter(currentPage: Page, onNavigate: (Page) -> Unit) {
    when (currentPage) {
        Page.HOME -> Home(onNavigate = onNavigate)
        Page.EXPERTISE -> Expertise(onNavigate = onNavigate)
        Page.FSM -> Fsm(onNavigate = onNavigate)
        Page.PORTFOLIO -> Portfolio(onNavigate = onNavigate)
        // Ces pages n'ont pas de boutons de redirection interne
        Page.CONTACT -> Contact()
        Page.LEGAL -> MentionsLegales()
    }
}

// Helper pour retrouver la page selon l'URL au chargement
fun parsePageFromUrl(path: String): Page {
    return Page.entries.find { it.route == path } ?: Page.HOME
}