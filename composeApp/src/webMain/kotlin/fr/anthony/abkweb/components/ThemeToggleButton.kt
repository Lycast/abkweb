package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.ThemeManager
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Img


@Composable
fun ThemeToggleButton() {
    Button({
        classes(
            "h-10", "w-10", "rounded-full", "flex", "items-center", "justify-center",
            "transition-all", "duration-1000", "shadow-sm", "hover:shadow-md", "cursor-pointer",
            "border", "focus:outline-none",
            *AppColors.bgMain,
            "border-slate-200", "dark:border-slate-700"
        )
        onClick { ThemeManager.toggle() }
    }) {
        val iconPath = if (ThemeManager.isDark) "/icon_moon.svg" else "/icon_sun.svg"

        Img(src = iconPath, attrs = {
            classes("h-5", "w-5", "transition-all", "duration-500", "dark:invert")
            alt("Changer le thème")
        })
    }
}