package fr.anthony.abkweb.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.browser.document
import kotlinx.browser.window

object ThemeManager {
    private const val THEME_KEY = "app_theme"

    var isDark by mutableStateOf(false)
        private set

    fun init() {
        val savedTheme = window.localStorage.getItem(THEME_KEY)
        val systemPrefersDark = window.matchMedia("(prefers-color-scheme: dark)").matches

        val shouldBeDark = savedTheme?.let { it == "dark" } ?: systemPrefersDark
        setTheme(shouldBeDark)
    }

    fun toggle() {
        setTheme(!isDark)
    }

    private fun setTheme(dark: Boolean) {
        isDark = dark
        val root = document.documentElement
        if (dark) {
            root?.classList?.add("dark")
            window.localStorage.setItem(THEME_KEY, "dark")
        } else {
            root?.classList?.remove("dark")
            window.localStorage.setItem(THEME_KEY, "light")
        }
    }
}