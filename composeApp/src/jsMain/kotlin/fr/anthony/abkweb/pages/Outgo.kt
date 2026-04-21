package fr.anthony.abkweb.pages

import androidx.compose.runtime.*
import fr.anthony.abkweb.PageOutgoLabels
import fr.anthony.abkweb.components.ImagesCarousel
import fr.anthony.abkweb.components.LightboxModal
import fr.anthony.abkweb.components.PrimaryButton
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.*

@Composable
fun Outgo(onNavigate: (Page) -> Unit) {

    // --- Gestion de l'état pour la modale du carrousel ---
    var lightboxImages by remember { mutableStateOf<List<String>?>(null) }
    var lightboxInitialIndex by remember { mutableStateOf(0) }

    // Liste des images pour le carrousel (Logo en premier, suivi des screenshots)
    val outgoImages = listOf(
        "/ss_outgo_00.webp",
        "/ss_outgo_01.webp",
        "/ss_outgo_02.webp",
        "/ss_outgo_03.webp",
        "/ss_outgo_04.webp"
    )

    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        // --- 1. SECTION HERO (Texte à gauche, Carrousel à droite) ---
        AppSection {
            Div({ classes("flex", "flex-col", "md:flex-row", "items-center", "gap-12", "max-w-6xl", "mx-auto") }) {

                // Zone Texte (Gauche)
                Div({
                    classes(
                        "flex-1",
                        "flex",
                        "flex-col",
                        "items-center",
                        "md:items-start",
                        "text-center",
                        "md:text-left"
                    )
                }) {
                    H1Custom(AppSpacing.marginM) {
                        Text(PageOutgoLabels.TITLE_A)
                        TextHighlight("text-${AppColors.accent}") { Text(PageOutgoLabels.TITLE_B) }
                    }
                    BodyText(AppSpacing.marginL) {
                        Text(PageOutgoLabels.DESCRIPTION)
                    }

                    // Bouton Télécharger
                    PrimaryButton(PageOutgoLabels.CTA_DOWNLOAD) {
                        // TODO: Ajouter le lien vers le Play Store ici plus tard via window.open()
                    }
                }

                // Zone Carrousel (Droite)
                Div({ classes("flex-1", "w-full", "max-w-md", "animate-fade-in") }) {
                    ImagesCarousel(
                        images = outgoImages,
                        onExpand = { idx ->
                            lightboxImages = outgoImages
                            lightboxInitialIndex = idx
                        }
                    )
                }
            }
        }

        // --- 2. SECTION DÉMO & PILIERS (Vidéo à gauche, Textes à droite) ---
        AppSection(useTightSpacing = true) {
            Div({
                classes(
                    "flex", "flex-col", "md:flex-row",
                    "items-center",
                    "gap-12", "max-w-6xl", "mx-auto", "mt-8"
                )
            }) {

                Div({ classes("flex-shrink-0", "flex", "justify-center", "md:justify-start", "w-full", "md:w-auto") }) {
                    Video(attrs = {
                        classes("w-full", "max-w-xs", "rounded-2xl", "shadow-xl", "border", *AppColors.border)
                        attr("controls", "")
                        attr("muted", "")
                        attr("playsinline", "")
                    }) {
                        Source(attrs = {
                            attr("src", "/demo_outgo.mp4")
                            attr("type", "video/mp4")
                        })
                        Text("Votre navigateur ne supporte pas la lecture de vidéos.")
                    }
                }

                // Zone Textes (Droite)
                Div({ classes("flex-1", "flex", "flex-col", "gap-8", "text-left") }) {
                    OutgoFeatureText(PageOutgoLabels.FEATURE_1_TITLE, PageOutgoLabels.FEATURE_1_DESC)
                    OutgoFeatureText(PageOutgoLabels.FEATURE_2_TITLE, PageOutgoLabels.FEATURE_2_DESC)
                    OutgoFeatureText(PageOutgoLabels.FEATURE_3_TITLE, PageOutgoLabels.FEATURE_3_DESC)
                    OutgoFeatureText(PageOutgoLabels.FEATURE_4_TITLE, PageOutgoLabels.FEATURE_4_DESC)
                }
            }
        }
    }

    // --- 3. SECTION À PROPOS (L'histoire du projet) ---
    AppSection {
        Div({ classes("flex", "flex-col", "md:flex-row",
            "items-center",
            "gap-12", "max-w-6xl", "mx-auto", "mt-8") }) {


            Div({ classes("flex-shrink-0") }) {
                Img(src = "/outgo_logo.webp", attrs = {
                    classes("w-24", "h-24", "opacity-80")
                    alt("Logo Outgo")
                })
            }


            Div({ classes("flex-1", "text-left") }) {
                H3Custom("mb-4") { Text(PageOutgoLabels.STORY_TITLE) }
                BodyText {
                    Text(PageOutgoLabels.STORY_DESC)
                }
            }
        }
    }

    // --- AFFICHAGE DE LA MODALE GLOBALE (Lightbox) ---
    lightboxImages?.let { images ->
        LightboxModal(
            images = images,
            initialIndex = lightboxInitialIndex,
            onClose = { lightboxImages = null }
        )
    }
}

// Sous-composant privé pour les blocs de texte à droite de la vidéo
@Composable
private fun OutgoFeatureText(title: String, desc: String) {
    Div({ classes("flex", "flex-col", "gap-2") }) {
        H3Custom { Text(title) }
        BodyText { Text(desc) }
    }
}