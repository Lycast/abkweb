package fr.anthony.abkweb.theme

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Section

@Composable
fun AppSection(
    useTightSpacing: Boolean = false,
    content: @Composable () -> Unit
) {
    val spacing = if (useTightSpacing) AppSpacing.sectionTight else AppSpacing.section

    Section({
        classes(*spacing,"w-full")
    }) {
        Div({ classes("container", "mx-auto", "px-6") }) {
            content()
        }
    }
}