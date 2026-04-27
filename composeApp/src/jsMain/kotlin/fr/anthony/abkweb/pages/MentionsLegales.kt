package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.data.PageMentionsLabels
import fr.anthony.abkweb.theme.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H2
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun MentionsLegales() {
    Div({ classes("flex-grow", "w-full", "flex", "flex-col") }) {
        AppSection {
            Div({ classes("max-w-3xl", "mx-auto", "text-left") }) {

                H1Custom("text-center", AppSpacing.marginL) {
                    Text(PageMentionsLabels.TITLE)
                }

                Div({ classes("flex", "flex-col", AppSpacing.stack, *AppColors.textSecondary) }) {

                    LegalBlock(PageMentionsLabels.LEGAL_BLOCK_A_LABEL) {
                        P { Text(PageMentionsLabels.BLOCK_A_TEXT_A) }
                        P { Text(PageMentionsLabels.BLOCK_A_TEXT_B) }
                        P { Text(PageMentionsLabels.BLOCK_A_TEXT_C) }
                        P { Text(PageMentionsLabels.BLOCK_A_TEXT_D) }
                    }

                    LegalBlock(PageMentionsLabels.LEGAL_BLOCK_B_LABEL) {
                        P { Text(PageMentionsLabels.BLOCK_B_TEXT_A) }
                        P { Text(PageMentionsLabels.BLOCK_B_TEXT_B) }
                    }

                    LegalBlock(PageMentionsLabels.LEGAL_BLOCK_C_LABEL) {
                        P { Text(PageMentionsLabels.BLOCK_C_TEXT_A) }
                    }
                }
            }
        }
    }
}

@Composable
private fun LegalBlock(title: String, content: @Composable () -> Unit) {
    Div({ classes("flex", "flex-col", "gap-3") }) {
        H2({ classes(*AppTypography.h3, *AppColors.textPrimary) }) {
            Text(title)
        }
        Div({ classes(*AppTypography.bodySmall) }) {
            content()
        }
    }
}