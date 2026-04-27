package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.data.CommonLabels
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
        Div({ classes("container", "mx-auto", "px-6", "py-2", "md:py-4", "flex", "justify-between", "items-center") }) {

            // --- 1. IDENTITÉ ---
            Div({
                classes("flex", "items-center", "gap-3", "md:gap-4", "cursor-pointer", "group")
                onClick {
                    isMobileMenuOpen = false
                    onNavigate(Page.HOME)
                }
            }) {
                Img(src = "/logo_key_color.webp", attrs = {
                    // On réduit légèrement le logo sur les petits écrans
                    classes("h-14", "w-auto", "object-contain",
                        "transition-transform", "duration-500",
                        "group-hover:rotate-90")
                    alt("Icône ABK Native")
                })

                Span({
                    classes(
                        "text-xl", "md:text-2xl", "font-heading", "font-bold", "tracking-tight",
                        "hover:underline", "hover:decoration-${AppColors.accent}", "hover:decoration-2", "underline-offset-4",
                        "text-brandPrimary", "relative", "sm:block",
                    )
                }) {
                    Text(CommonLabels.ABK_NATIVE)
                }
            }

            // --- 2. ACTIONS & NAVIGATION ---
            Div({ classes("flex", "items-center", "gap-4") }) {

                // NAVIGATION BUREAU
                Nav({ classes("hidden", "md:flex", "gap-8", "items-center") }) {
                    DesktopNavLink(CommonLabels.NAV_EXPERTISE, currentPage == Page.EXPERTISE) { onNavigate(Page.EXPERTISE) }
                    DesktopNavLink(CommonLabels.NAV_OUTGO, currentPage == Page.OUTGO) { onNavigate(Page.OUTGO) }
                    DesktopNavLink(CommonLabels.NAV_PORTFOLIO, currentPage == Page.PORTFOLIO) { onNavigate(Page.PORTFOLIO) }
                    PrimaryButton(CommonLabels.NAV_CONTACT) { onNavigate(Page.CONTACT) }
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
                MobileNavLink(CommonLabels.NAV_HOME, currentPage == Page.HOME) { isMobileMenuOpen = false; onNavigate(Page.HOME) }
                MobileNavLink(CommonLabels.NAV_EXPERTISE, currentPage == Page.EXPERTISE) { isMobileMenuOpen = false; onNavigate(Page.EXPERTISE) }
                MobileNavLink(CommonLabels.NAV_OUTGO, currentPage == Page.OUTGO) { isMobileMenuOpen = false; onNavigate(Page.OUTGO) }
                MobileNavLink(CommonLabels.NAV_PORTFOLIO, currentPage == Page.PORTFOLIO) { isMobileMenuOpen = false; onNavigate(Page.PORTFOLIO) }
                PrimaryButton(CommonLabels.NAV_CONTACT) { isMobileMenuOpen = false; onNavigate(Page.CONTACT) }
            }
        }
    }
}

// --- Sous-composants ---
@Composable
private fun DesktopNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-brandPrimary", "dark:text-brandPrimary") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            *AppColors.hoverBrand,
            "transition-colors",
            "duration-200"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}

@Composable
private fun MobileNavLink(text: String, isActive: Boolean, onClick: () -> Unit) {
    A(href = "#", {

        val colorClasses = if (isActive) arrayOf("text-brandPrimary", "dark:text-brandPrimary") else AppColors.textSecondary

        classes(
            *colorClasses,
            if (isActive) "font-bold" else "font-medium",
            *AppColors.hoverBrand,
            "text-lg",
            "block",
            "w-full",
            "text-center",
            "transition-colors",
            "duration-200"
        )
        onClick { it.preventDefault(); onClick() }
    }) { Text(text) }
}