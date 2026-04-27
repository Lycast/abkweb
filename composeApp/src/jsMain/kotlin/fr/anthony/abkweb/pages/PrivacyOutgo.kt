package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.data.PrivacyOutgoLabels
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.*

@Composable
fun PrivacyOutgo(onNavigate: (Page) -> Unit) {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            Div({ classes("max-w-4xl", "mx-auto", "py-12", "animate-fade-in") }) {

                H2Custom(AppSpacing.marginL) { Text(PrivacyOutgoLabels.TITLE) }

                // 1. Introduction
                PrivacySection(PrivacyOutgoLabels.INTRO_TITLE) {
                    BodyText { Text(PrivacyOutgoLabels.INTRO_DESC) }
                }

                // 2. Collecte (avec boucle sur la liste)
                PrivacySection(PrivacyOutgoLabels.DATA_TITLE) {
                    BodyText(AppSpacing.marginL) { Text(PrivacyOutgoLabels.DATA_INTRO) }
                    PrivacyBulletList(PrivacyOutgoLabels.DATA_POINTS)
                }

                // 3. Tiers (avec boucle sur la liste)
                PrivacySection(PrivacyOutgoLabels.TIER_TITLE) {
                    BodyText(AppSpacing.marginL) { Text(PrivacyOutgoLabels.TIER_INTRO) }
                    PrivacyBulletList(PrivacyOutgoLabels.TIER_POINTS)
                }

                // 4. Sécurité
                PrivacySection(PrivacyOutgoLabels.SECURITY_TITLE) {
                    BodyText { Text(PrivacyOutgoLabels.SECURITY_DESC) }
                }

                // 5. Suppression
                PrivacySection(PrivacyOutgoLabels.CLEAR_DATA_TITLE) {
                    BodyText { Text(PrivacyOutgoLabels.CLEAR_DATA_DESC) }
                }

                // 6. Contact
                PrivacySection(PrivacyOutgoLabels.CONTACT_TITLE) {
                    BodyText {
                        Text(PrivacyOutgoLabels.CONTACT_SUB)
                        A(href = PrivacyOutgoLabels.CONTACT_URL, attrs = {
                            classes("text-${AppColors.accent}", "hover:underline")
                        }) {
                            Text(PrivacyOutgoLabels.CONTACT_LINK_TEXT)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PrivacySection(title: String, content: @Composable () -> Unit) {
    Div({ classes("mb-12") }) {
        H3Custom(AppSpacing.marginL) { Text(title) }
        content()
    }
}

@Composable
private fun PrivacyBulletList(points: List<Pair<String, String>>) {
    Ul({ classes("list-disc", "ml-6", "mt-4", "space-y-4") }) {
        points.forEach { (label, desc) ->
            Li {
                BodyText {
                    B { Text("$label : ") }
                    Text(desc)
                }
            }
        }
    }
}