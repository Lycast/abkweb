package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

/**
 * Bouton d'action principal (CTA).
 * Utilise ta couleur Primaire officielle #285abf.
 */
@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button({
        classes(
            "bg-brandPrimary",     // Ton bleu officiel
            "text-white",
            "px-6", "py-3",
            "rounded-lg",
            "font-bold",
            "hover:bg-blue-700",    // Un bleu un peu plus sombre au survol
            "transition-all",       // Transition fluide
            "duration-300",
            "shadow-md",
            "active:scale-95"      // Petit effet de pression au clic (très "natif")
        )
        onClick { onClick() }
    }) {
        Text(text)
    }
}

/**
 * Bouton d'action secondaire (Outline).
 * Utilise ta couleur Secondaire #7b77c9 pour la bordure.
 */
@Composable
fun SecondaryButton(text: String, onClick: () -> Unit) {

    val dynamicBorder = arrayOf("border-slate-200", "dark:border-slate-800")

    A(href = "#", {
        classes(
            "px-6", "py-3",
            "font-bold",
            "rounded-lg",
            "border-2",
            *dynamicBorder,
            "hover:border-brandPrimary",
            "hover:text-brandPrimary",
            "transition-all",
            "duration-300",
            "flex", "items-center", "justify-center",
            "active:scale-95",
            *AppColors.textPrimary
        )
        onClick {
            it.preventDefault()
            onClick()
        }
    }) {
        Text(text)
    }
}