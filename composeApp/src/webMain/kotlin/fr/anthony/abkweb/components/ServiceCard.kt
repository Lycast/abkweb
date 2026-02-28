package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.*

@Composable
fun ServiceCard(
    title: String,
    description: String,
    icon: String,
    tag: String? = null
) {
    Div({
        classes(
            "group", "p-8", "rounded-2xl", "border-2", "border-slate-800",
            "hover:border-brandPrimary", "transition-all", "duration-500",
            "bg-slate-900/20", "hover:bg-slate-900/40", "flex", "flex-col", "gap-4"
        )
    }) {
        // L'icône ou le symbole en OR
        Span({
            classes("text-3xl", "text-brandAccent", "group-hover:scale-110", "transition-transform")
        }) {
            Text(icon)
        }

        if (tag != null) {
            Span({
                classes("w-fit", "px-3", "py-1", "text-xs", "font-bold", "rounded-full", "bg-brandPrimary/10", "text-brandPrimary")
            }) {
                Text(tag)
            }
        }

        H3({
            classes("text-2xl", "font-heading", "font-bold", "text-white")
        }) {
            Text(title)
        }

        P({
            classes("text-slate-400", "leading-relaxed")
        }) {
            Text(description)
        }
    }
}