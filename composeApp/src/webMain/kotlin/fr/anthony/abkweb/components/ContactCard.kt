package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
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
            "p-8", "rounded-2xl", "border-2",
            "border-slate-200", "dark:border-slate-800",
            "flex", "flex-col", "items-center", "text-center", "gap-4",
            "h-full", // Aligne la hauteur des cartes
            *AppColors.bgSection
        )
    }) {
        // 1. Icône intelligente (Détecte si c'est une image ou un emoji)
        Span({ classes("text-4xl", "mb-4", "flex", "justify-center", "items-center", "h-10") }) {
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
        H3({ classes("text-xl", "font-heading", "font-bold", *AppColors.textPrimary) }) {
            Text(title)
        }

        // 3. Description
        P({ classes("text-sm", "leading-relaxed", *AppColors.textSecondary) }) {
            Text(description)
        }

        // 4. Zone d'action (Bouton ou Texte, poussé vers le bas)
        Div({ classes("mt-auto", "pt-4") }) {
            if (actionLink != null) {
                val dynamicBorder = arrayOf("border-slate-200", "dark:border-slate-800")

                A(href = actionLink, attrs = {
                    classes(
                        "px-6", "py-3", "font-bold", "rounded-lg", "border-2",
                        *dynamicBorder,
                        "hover:border-brandPrimary", "hover:text-brandPrimary",
                        "transition-all", "duration-300",
                        "flex", "items-center", "justify-center", "active:scale-95",
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
                    classes("text-sm", "font-bold", "text-brandPrimary", "dark:text-brandSecondary")
                }) {
                    Text(actionText)
                }
            }
        }
    }
}