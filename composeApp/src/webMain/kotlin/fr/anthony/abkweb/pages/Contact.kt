package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.*
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Contact() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {

        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-4xl", "mx-auto") }) {

                // 1. HEADER CONTACT
                H1Custom(extraClasses = arrayOf("mb-6")) {
                    Text("Discutons de votre ")
                    TextHighlight(colorClass = AppColors.accent) { Text("projet") }
                }

                BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", "mb-16")) {
                    Text("Vous avez un besoin spécifique en développement Kotlin Multiplatform, ou vous souhaitez en savoir plus sur ma future solution FSM ? N'hésitez pas à me contacter directement.")
                }

                // 2. GRILLE DE CONTACT (3 colonnes)
                Div({
                    classes("w-full", "grid", "grid-cols-1", "md:grid-cols-3", "gap-8")
                }) {

                    // Carte 1 : EMAIL (Action Principale)
                    ContactCard(
                        icon = "/icon_mail.png",
                        title = "Par Email",
                        description = "Je réponds généralement sous 24h.",
                        actionText = "m'écrire un email",
                        actionLink = "mailto:contact@abknative.fr"
                    )

                    // Carte 3 : LINKEDIN
                    ContactCard(
                        icon = "/icon_linkedin.png",
                        title = "LinkedIn",
                        description = "Suivez mon actualité professionnelle et mon réseau.",
                        actionText = "Voir mon profil",
                        actionLink = "https://www.linkedin.com/in/anthony-brenon-a7761b213"
                    )
                }
            }
        }
    }
}

