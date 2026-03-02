package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppShapes
import fr.anthony.abkweb.theme.AppSpacing
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

/**
 * Bouton d'action principal (CTA).
 */
@Composable
fun PrimaryButton(text: String, onClick: () -> Unit) {
    Button({
        classes(
            "bg-brandPrimary", "text-white",
            *AppSpacing.btnPadding,
            AppShapes.button,
            "font-bold",
            AppColors.hoverBrightness,
            *AppColors.themeTransition,
            AppColors.shadow,
            "active:scale-90"
        )
        onClick { onClick() }
    }) {
        Text(text)
    }
}

/**
 * Bouton d'action secondaire (Outline).
 */
@Composable
fun SecondaryButton(text: String, onClick: () -> Unit) {
    Button({
        classes(
            "bg-transparent", "border-2",
            *AppColors.border,
            *AppSpacing.btnPadding,
            AppShapes.button,
            "font-bold",
            *AppColors.hoverBrand,
            *AppColors.textPrimary,
            *AppColors.themeTransition,
            "active:scale-90"
        )
        onClick { onClick() }
    }) {
        Text(text)
    }
}