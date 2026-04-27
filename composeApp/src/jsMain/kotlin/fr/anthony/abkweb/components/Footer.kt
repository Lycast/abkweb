package fr.anthony.abkweb.components

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.data.CommonLabels
import fr.anthony.abkweb.data.FooterLabels
import fr.anthony.abkweb.data.UrlLabels
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.AppSpacing
import fr.anthony.abkweb.theme.AppTypography
import org.jetbrains.compose.web.attributes.ATarget
import org.jetbrains.compose.web.attributes.target
import org.jetbrains.compose.web.dom.*

@Composable
fun FooterComponent(onNavigate: (Page) -> Unit) {
    Footer({
        classes(
            "w-full", "mt-auto",
            "bg-black",
            *AppSpacing.sectionTight
        )
    }) {
        Div({ classes("container", "mx-auto", "px-6", "max-w-6xl") }) {

            // --- GRILLE PRINCIPALE ---
            Div({ classes("grid", "grid-cols-1", "md:grid-cols-3", AppSpacing.blockGap[0], "md:" + AppSpacing.blockGap[1], "mb-12") }) {

                // 1. Identité
                Div({ classes("flex", "flex-col", "gap-4") }) {
                    Span({
                        classes("text-2xl", "font-heading", "font-bold", "text-brandPrimary")
                    }) {
                        Text(CommonLabels.ABK_NATIVE)
                    }
                    P({ classes(*AppTypography.bodySmall, "text-slate-400") }) {
                        Text(FooterLabels.DESCRIPTION)
                    }
                }

                // 2. Navigation
                Div({ classes("flex", "flex-col", "gap-3") }) {
                    H3({
                        classes( *AppTypography.h3, "text-slate-300", *AppColors.themeTransition)
                    }) {
                        Text(FooterLabels.NAV)
                    }
                    FooterInternalLink(CommonLabels.NAV_EXPERTISE, Page.EXPERTISE, onNavigate)
                    FooterInternalLink(CommonLabels.NAV_OUTGO, Page.OUTGO, onNavigate)
                    FooterInternalLink(CommonLabels.NAV_PORTFOLIO, Page.PORTFOLIO, onNavigate)
                    FooterInternalLink(CommonLabels.NAV_CONTACT, Page.CONTACT, onNavigate)
                }

                // 3. Réseaux & Légal
                Div({ classes("flex", "flex-col", "gap-3") }) {
                    H3({
                        classes( *AppTypography.h3, "text-slate-300", *AppColors.themeTransition)
                    }) {
                        Text(FooterLabels.SOCIAL)
                    }
                    FooterExternalLink(FooterLabels.LINKEDIN, UrlLabels.URL_LINKEDIN)
                    FooterExternalLink(FooterLabels.GITHUB, UrlLabels.URL_GIT_HOME)

                    Div({ classes("mt-4", "flex", "flex-col", "gap-3") }) {
                        FooterInternalLink(FooterLabels.MENTION, Page.LEGAL, onNavigate)
                        FooterInternalLink(CommonLabels.NAV_PRIVACY_OUTGO, Page.PRIVACY_OUTGO, onNavigate)
                    }
                }
            }

            // Séparateur horizontal
            Hr({ classes("w-full", "opacity-50", "mb-8", "text-slate-300") })

            // Copyright
            Div({ classes("text-center", *AppTypography.caption, "text-slate-400") }) {
                Text(FooterLabels.TEXT_BOTTOM)
            }
        }
    }
}

// --- SOUS-COMPOSANTS DE LIENS ---
@Composable
private fun FooterInternalLink(text: String, page: Page, onNavigate: (Page) -> Unit) {
    A(href = "#", attrs = {
        classes(
            "w-fit", "transition-colors", "duration-200",
            *AppTypography.bodySmall, "text-slate-400", *AppColors.hoverBrand
        )
        onClick {
            it.preventDefault()
            onNavigate(page)
        }
    }) { Text(text) }
}

@Composable
private fun FooterExternalLink(text: String, url: String) {
    A(href = url, attrs = {
        classes(
            "w-fit", "transition-colors", "duration-200",
            *AppTypography.bodySmall, "text-slate-400", *AppColors.hoverBrand
        )
        target(ATarget.Blank)
    }) { Text(text) }
}