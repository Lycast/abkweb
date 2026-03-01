package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppSpacing
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.*

@Composable
fun HeaderComponent(currentPage: Page, onNavigate: (Page) -> Unit) {

    var isMobileMenuOpen by remember { mutableStateOf(false) }

    Header({
        classes("w-full", "backdrop-blur-md", *AppColors.bgMain, *AppColors.themeTransition,
            "sticky", "top-0", "z-50", AppColors.shadow, "relative")
    }) {
        Div({ classes("container", "mx-auto", "px-6", "py-4", "flex", "justify-between", "items-center") }) {

            // --- 1. IDENTITÉ ---
            Div({
                classes("flex", "items-center", "gap-3", "md:gap-4", "cursor-pointer", "group")
                onClick {
                    isMobileMenuOpen = false
                    onNavigate(Page.HOME)
                }
            }) {
                Img(src = "/logo_key_color.png", attrs = {
                    // On réduit légèrement le logo sur les petits écrans
                    classes("h-14", "w-auto", "object-contain", "transition-transform", "duration-500", "group-hover:rotate-90")
                    alt("Icône ABK Native")
                })

                Span({
                    classes(
                        "text-xl", "md:text-2xl", "font-heading", "font-bold", "tracking-tight",
                        "text-${AppColors.primary}", "relative", "sm:block",
                    )
                }) {
                    Text("ABK Native")
                }
            }

            // --- 2. ACTIONS & NAVIGATION ---
            Div({ classes("flex", "items-center", "gap-4") }) {

                // NAVIGATION BUREAU
                Nav({ classes("hidden", "md:flex", "gap-8", "items-center") }) {
                    DesktopNavLink("Expertise", currentPage == Page.EXPERTISE) { onNavigate(Page.EXPERTISE) }
                    DesktopNavLink("Solution FSM", currentPage == Page.FSM) { onNavigate(Page.FSM) }
                    DesktopNavLink("Portfolio", currentPage == Page.PORTFOLIO) { onNavigate(Page.PORTFOLIO) }
                    PrimaryButton("Me contacter") { onNavigate(Page.CONTACT) }
                }

                // BOUTON BURGER
                Button({
                    classes("md:hidden", *AppColors.textPrimary, "text-3xl", "focus:outline-none", "ml-2")
                    onClick { isMobileMenuOpen = !isMobileMenuOpen }
                }) {
                    Text(if (isMobileMenuOpen) "✕" else "☰")
                }
            }
        }

        // --- 3. MENU MOBILE---
        if (isMobileMenuOpen) {
            Div({
                classes(
                    "md:hidden", "absolute", "top-full", "left-0", "w-full", *AppColors.bgMain, AppColors.shadow,
                    "border-t", *AppColors.border, "flex", "flex-col", "p-6", AppSpacing.stack, *AppColors.themeTransition
                )
            }) {
                MobileNavLink("Accueil", currentPage == Page.HOME) { isMobileMenuOpen = false; onNavigate(Page.HOME) }
                MobileNavLink("Expertise KMP", currentPage == Page.EXPERTISE) { isMobileMenuOpen = false; onNavigate(Page.EXPERTISE) }
                MobileNavLink("Solution FSM", currentPage == Page.FSM) { isMobileMenuOpen = false; onNavigate(Page.FSM) }
                MobileNavLink("Portfolio", currentPage == Page.PORTFOLIO) { isMobileMenuOpen = false; onNavigate(Page.PORTFOLIO) }
                PrimaryButton("Me contacter") { isMobileMenuOpen = false; onNavigate(Page.CONTACT) }
            }
        }
    }
}

// --- Sous-composants ---
@Composable
private fun DesktopNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-${AppColors.secondary}") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            *AppColors.hoverBrand,
            "transition-colors"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}

@Composable
private fun MobileNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-${AppColors.secondary}") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            *AppColors.hoverBrand,
            "text-lg",
            "block",
            "w-full",
            "text-center",
            "transition-colors"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}