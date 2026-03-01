package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppShapes
import fr.anthony.abkweb.theme.AppSpacing
import fr.anthony.abkweb.theme.AppTypography
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*

@Composable
fun ContactCard(
    icon: String,
    title: String,
    description: String,
    actionText: String,
    actionLink: String?
) {
    Div({
        classes(
            AppSpacing.card, AppShapes.card, "border-2", *AppColors.border, "flex", "flex-col",
            "items-center", "text-center", AppSpacing.cardGap, "h-full", *AppColors.bgAlt, *AppColors.themeTransition
        )
    }) {
        // 1. Icône intelligente (Détecte si c'est une image ou un emoji)
        Span({ classes("text-4xl", "mb-2", "flex", "justify-center", "items-center", "h-10") }) {
            if (icon.contains(".")) {
                Img(src = icon, attrs = {
                    classes("w-10", "h-10", "object-contain")
                    alt("Logo $title")
                })
            } else {
                Text(icon)
            }
        }

        // 2. Titre
        H3({ classes(*AppTypography.h3, *AppColors.textPrimary) }) {
            Text(title)
        }

        // 3. Description
        P({ classes(*AppTypography.bodySmall, *AppColors.textSecondary) }) {
            Text(description)
        }

        // 4. Zone d'action (Bouton ou Texte, poussé vers le bas)
        Div({ classes("mt-auto", "pt-4", "w-full") }) {
            if (actionLink != null) {
                val dynamicBorder = arrayOf("border-slate-200", "dark:border-slate-800")

                A(href = actionLink, attrs = {
                    classes(
                        "w-full", "inline-flex", "items-center", "justify-center",
                        *AppSpacing.btnPadding, "font-bold", AppShapes.button, "border-2",
                        *AppColors.border, *AppColors.hoverBrand,
                        "transition-all", "duration-1000", "active:scale-95",
                        *AppColors.textPrimary
                    )
                    if (actionLink.startsWith("http")) {
                        target(ATarget.Blank)
                    }
                }) {
                    Text(actionText)
                }
            } else {
                Span({
                    classes("text-sm", "font-bold", AppColors.accent)
                }) {
                    Text(actionText)
                }
            }
        }
    }
}