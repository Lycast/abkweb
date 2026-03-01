package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.ContactCard
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Contact() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        AppSection {
            Div({ classes("flex", "flex-col", "items-center", "text-center", "max-w-4xl", "mx-auto") }) {

                // --- 1. HEADER CONTACT ---
                H1Custom(AppSpacing.marginM) {
                    Text("Discutons de votre ")
                    TextHighlight(colorClass = AppColors.accent) { Text("projet") }
                }

                BodyText("max-w-2xl", "mx-auto", AppSpacing.marginL) {
                    Text("Vous avez un besoin spécifique en développement Kotlin Multiplatform, ou vous souhaitez en savoir plus sur ma future solution FSM ? N'hésitez pas à me contacter directement.")
                }

                // --- 2. GRILLE DE CONTACT ---
                Div({
                    classes("w-full", "grid", "grid-cols-1", "md:grid-cols-2", "lg:grid-cols-3", *AppSpacing.blockGap)
                }) {

                    // Carte 1 : EMAIL
                    ContactCard(
                        icon = "/icon_mail.png",
                        title = "Par Email",
                        description = "Je réponds généralement sous 24h.",
                        actionText = "M'écrire un email",
                        actionLink = "mailto:contact@abknative.fr"
                    )

                    // Carte 2 : LINKEDIN
                    ContactCard(
                        icon = "/icon_linkedin.png",
                        title = "LinkedIn",
                        description = "Suivez mon actualité professionnelle et mon réseau.",
                        actionText = "Voir mon profil",
                        actionLink = "https://www.linkedin.com/in/anthony-brenon-a7761b213"
                    )

                    // Note : md:grid-cols-2 car il n'y a que 2 cartes ici.
                    // Si on ajoutes une 3ème, repasser en md:grid-cols-3.
                }
            }
        }
    }
}

