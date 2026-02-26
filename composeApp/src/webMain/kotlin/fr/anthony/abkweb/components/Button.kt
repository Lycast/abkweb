package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

/**
 * Bouton d'action principal (Call To Action).
 * Utilise la couleur 'emerald' définie dans le thème Tailwind.
 */
@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button({
        classes(
            "bg-emerald",
            "text-white",
            "px-6",
            "py-3",
            "rounded-lg",
            "font-bold",
            "hover:bg-green-600",
            "transition-colors",
            "shadow-md"
        )
        // On connecte l'événement clic du DOM à la fonction Kotlin passée en paramètre
        onClick { onClick() }
    }) {
        Text(text)
    }
}

@Composable
fun SecondaryButton(text: String, onClick: () -> Unit) {
    A(href = "#", {
        classes(
            // Dimensions exactes du PrimaryButton pour un alignement parfait
            "px-6", "py-3", "font-bold", "rounded-lg",

            // La bordure qui crée le bouton visuellement
            "border-2", "border-slate-200", "dark:border-slate-700",

            // Comportement au survol
            "hover:border-cobalt", "hover:text-cobalt",

            // Alignement et couleurs de base
            "transition-colors", "flex", "items-center", "justify-center",
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