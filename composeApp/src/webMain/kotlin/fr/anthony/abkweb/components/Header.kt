package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.*

@Composable
fun HeaderComponent(currentPage: Page, onNavigate: (Page) -> Unit) {

    // État local pour savoir si le menu mobile est ouvert
    var isMobileMenuOpen by remember { mutableStateOf(false) }

    // On ajoute "relative" pour pouvoir positionner le menu mobile en dessous
    Header({
        classes("w-full", *AppColors.bgMain, "backdrop-blur-md", "sticky", "top-0", "z-50", "shadow-sm", "relative")
    }) {
        Div({ classes("container", "mx-auto", "px-6", "py-4", "flex", "justify-between", "items-center") }) {

            // 1. Logo
            Div({
                classes("text-2xl", "font-heading", "font-bold", "text-cobalt", "cursor-pointer")
                onClick {
                    isMobileMenuOpen = false // On ferme le menu si on clique sur le logo
                    onNavigate(Page.HOME)
                }
            }) {
                Text("ABK Native")
            }

            // 2. Navigation Bureau
            Nav({ classes("hidden", "md:flex", "gap-8", "items-center") }) {
                DesktopNavLink("Expertise", currentPage == Page.EXPERTISE) { onNavigate(Page.EXPERTISE) }
                DesktopNavLink("Solution FSM", currentPage == Page.FSM) { onNavigate(Page.FSM) }
                PrimaryButton("Me contacter") { onNavigate(Page.CONTACT) }
            }

            // 3. Bouton Burger Mobile
            Button({
                classes("md:hidden", *AppColors.textPrimary, "text-3xl", "focus:outline-none")
                onClick { isMobileMenuOpen = !isMobileMenuOpen }
            }) {
                // Icône Burger simple en texte (peut être remplacée par un SVG Lucide plus tard)
                Text(if (isMobileMenuOpen) "✕" else "☰")
            }
        }

        // 4. Le Menu Déroulant Mobile
        if (isMobileMenuOpen) {
            Div({
                // "absolute top-full left-0" le place pile sous le header
                classes(
                    "md:hidden", "absolute", "top-full", "left-0", "w-full", *AppColors.bgMain, "shadow-lg",
                    "border-t", "border-slate-100", "flex", "flex-col", "p-6", "gap-6"
                )
            }) {
                MobileNavLink("Accueil", currentPage == Page.HOME) {
                    isMobileMenuOpen = false; onNavigate(Page.HOME)
                }
                MobileNavLink("Expertise KMP", currentPage == Page.EXPERTISE) {
                    isMobileMenuOpen = false; onNavigate(Page.EXPERTISE)
                }
                MobileNavLink("Solution FSM", currentPage == Page.FSM) {
                    isMobileMenuOpen = false; onNavigate(Page.FSM)
                }
                PrimaryButton("Me contacter") {
                    isMobileMenuOpen = false; onNavigate(Page.CONTACT)
                }
            }
        }
    }
}

// --- Sous-composants pour garder le code propre ---

@Composable
private fun DesktopNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-cobalt") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            "hover:text-cobalt",
            "transition-colors"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}

@Composable
private fun MobileNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-cobalt") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            "text-lg",
            "block",
            "w-full",
            "text-center",
            "transition-colors"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}