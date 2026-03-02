package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.*
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
        H3Custom { Text(title) }

        // 3. Description
        BodyText { Text(description) }

        // 4. Zone d'action (Bouton ou Texte, poussé vers le bas)
        Div({ classes("mt-auto", "pt-4", "w-full") }) {
            if (actionLink != null) {

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