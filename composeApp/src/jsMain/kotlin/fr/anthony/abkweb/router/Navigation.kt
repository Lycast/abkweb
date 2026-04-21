package fr.anthony.abkweb.router

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.pages.*

enum class Page(val route: String) {
    HOME("/"),
    EXPERTISE("/expertise"),
    OUTGO("/outgo"),
    CONTACT("/contact"),
    PORTFOLIO("/portfolio"),
    LEGAL("/legal")
}

@Composable
fun PageRouter(currentPage: Page, onNavigate: (Page) -> Unit) {
    when (currentPage) {
        Page.HOME -> Home(onNavigate = onNavigate)
        Page.EXPERTISE -> Expertise(onNavigate = onNavigate)
        Page.OUTGO -> Outgo(onNavigate = onNavigate)
        Page.PORTFOLIO -> Portfolio()
        Page.CONTACT -> Contact()
        Page.LEGAL -> MentionsLegales()
    }
}

fun parsePageFromUrl(path: String): Page {
    return Page.entries.find { it.route == path } ?: Page.HOME
}