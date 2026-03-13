package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.CommonLabels
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppSpacing
import fr.anthony.abkweb.theme.BodyText
import fr.anthony.abkweb.theme.H3Custom
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun FeatureBlock(
    title: String,
    description: String,
    ctaText: String,
    isReversed: Boolean = false,
    onCtaClick: () -> Unit,
    visualContent: @Composable () -> Unit,
    isExpandable: Boolean = false,
    isExpanded: Boolean = false,
    onToggle: () -> Unit = {},
    expandedContent: (@Composable () -> Unit)? = null
) {
    val layoutDirection = if (isReversed) "md:flex-row-reverse" else "md:flex-row"

    // Conteneur global
    Div({ classes("flex", "flex-col", "w-full") }) {


        // --- 1. TITRE MOBILE (Affiché en haut sur mobile, caché sur desktop) ---
        H3Custom("block", "md:hidden", "text-center") { Text(title) }


        // --- 2. CONTENEUR DES DEUX ZONES (Flex row sur desktop) ---
        Div({
            classes(
                "flex", "flex-col", layoutDirection,
                "items-center",
                *AppSpacing.blockGap, *AppSpacing.sectionTight
            )
        }) {

            // --- ZONE TEXTE ---
            // Sur mobile : order-2 (passe SOUS l'image). Sur desktop : order-none (reprend sa place naturelle)
            Div({
                classes(
                    "w-full", "md:w-1/2", "flex", "flex-col", AppSpacing.stack,
                    "order-2", "md:order-none"
                )
            }) {

                // TITRE DESKTOP (Caché sur mobile, affiché sur desktop pour garder l'alignement avec le texte)
                H3Custom("hidden", "md:block") { Text(title) }

                BodyText("whitespace-pre-wrap") { Text(description) }

                // Logique du bouton conditionnelle
                if (isExpandable) {
                    if (!isExpanded) {
                        Button({
                            classes("text-brandPrimary", "font-bold", "text-left", "hover:underline", "w-max", "mt-2")
                            onClick { onToggle() }
                        }) {
                            Text(CommonLabels.ACTION_MORE)
                        }
                    }
                } else {
                    Div({ classes("w-fit", "mt-4") }) {
                        SecondaryButton(text = ctaText, onClick = onCtaClick)
                    }
                }
            }

            // --- ZONE VISUELLE ---
            // Sur mobile : order-1 (passe AU-DESSUS du texte). Sur desktop : order-none
            Div({
                classes(
                    "w-full", "md:w-1/2", "flex", "justify-center",
                    "order-1", "md:order-none"
                )
            }) {
                visualContent()
            }
        }

        // --- 3. PARTIE BASSE (Contenu étendu) ---
        if (isExpandable && isExpanded && expandedContent != null) {
            Div({
                classes(
                    "w-full", "flex", "flex-col", "gap-6", "pb-4",
                    *AppColors.themeTransition
                )
            }) {
                expandedContent()
            }
        }
    }
}