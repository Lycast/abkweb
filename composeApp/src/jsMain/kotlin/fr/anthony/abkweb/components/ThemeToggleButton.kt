package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.ButtonLabels
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.ThemeManager
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text


@Composable
fun ThemeToggleButton() {
    Button({
        classes(
            "h-10", "w-auto", "px-3", "rounded-lg",
            "flex", "items-center", "gap-2",
            "transition-all", "duration-1000", "cursor-pointer",
            "border", "focus:outline-none",
            "bg-dark/10", "dark:bg-white/05",
            "border-slate-200/50", "dark:border-slate-700/50",
            "hover:bg-brandPrimary/20"
        )
        onClick { ThemeManager.toggle() }
    }) {
        // Texte
        Span({
            classes("text-xs", "font-bold", "uppercase", "tracking-wider", *AppColors.textSecondary)
        }) {
            Text(if (ThemeManager.isDark) ButtonLabels.DARK else ButtonLabels.LIGHT)
        }

        val iconPath = if (ThemeManager.isDark) "/icon_moon.svg" else "/icon_sun.svg"

        Div({
            classes("h-4", "w-4", "transition-all", "duration-500")
            classes(*AppColors.textSecondary)
            classes("bg-current")

            style {
                // Configuration du masque CSS
                property("-webkit-mask-image", "url('$iconPath')")
                property("mask-image", "url('$iconPath')")
                property("-webkit-mask-repeat", "no-repeat")
                property("mask-repeat", "no-repeat")
                property("-webkit-mask-size", "contain")
                property("mask-size", "contain")
                property("-webkit-mask-position", "center")
                property("mask-position", "center")
            }
        }) {}
    }
}