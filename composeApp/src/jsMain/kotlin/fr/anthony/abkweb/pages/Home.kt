package fr.anthony.abkweb.pages

import androidx.compose.runtime.*
import fr.anthony.abkweb.PageHomeLabels
import fr.anthony.abkweb.components.FeatureBlock
import fr.anthony.abkweb.components.ImagesCarousel
import fr.anthony.abkweb.components.LightboxModal
import fr.anthony.abkweb.data.featureList
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

@Composable
fun Home(
    onNavigate: (Page) -> Unit
) {

    var lightboxImages by remember { mutableStateOf<List<String>?>(null) }
    var lightboxInitialIndex by remember { mutableStateOf(0) }

    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {

        Div({ classes("container", "mx-auto", "px-6") }) {

            // --- 1. SECTION HERO ---
            Div({ classes(
                "text-center", "animate-fade-in",
                *AppSpacing.sectionTight
            )
            }) {
                H1Custom(AppSpacing.marginM) {
                    Text(PageHomeLabels.TITLE_A)
                    TextHighlight("text-${AppColors.accent}") { Text(PageHomeLabels.TITLE_B) }
                    Text(PageHomeLabels.TITLE_C)
                }

                BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", AppSpacing.marginL)) {
                    Text(PageHomeLabels.DESCRIPTION)
                }
            }

            // --- 2. BLOCS NARRATIFS ---
            Div({ classes("flex", "flex-col", "w-full", "animate-fade-in-up") }) {

                featureList.forEachIndexed { index, feature ->
                    FeatureBlock(
                        title = feature.title,
                        description = feature.description,
                        ctaText = feature.ctaText,
                        onCtaClick = { onNavigate(feature.onCtaClick) },
                        isReversed = index % 2 != 0,
                        visualContent = {
                            ImagesCarousel(
                                images = feature.images,
                                onExpand = { idx ->
                                    lightboxImages = feature.images
                                    lightboxInitialIndex = idx
                                }
                            )
                        }
                    )
                }
            }
        }
    }

    // --- AFFICHAGE DE LA MODALE GLOBALE ---
    lightboxImages?.let { images ->
        LightboxModal(
            images = images,
            initialIndex = lightboxInitialIndex,
            onClose = { lightboxImages = null }
        )
    }
}