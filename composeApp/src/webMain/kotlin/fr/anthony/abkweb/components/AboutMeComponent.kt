package fr.anthony.abkweb.components

import androidx.compose.runtime.*
import fr.anthony.abkweb.theme.AppColors
import fr.anthony.abkweb.theme.H3Custom
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutMeComponent() {
    // État pour gérer l'ouverture/fermeture du texte
    var isExpanded by remember { mutableStateOf(false) }

    Div({ classes(*AppColors.textPrimary, *AppColors.themeTransition) }) {

        // --- 1ère Partie (Toujours visible) ---
        H3Custom("font-bold", "text-xl", "mb-3") {
            Text("Du terrain au numérique : l'art d'évoluer.")
        }

        P({ classes("text-base", "leading-relaxed") }) {
            Text("Mon parcours n'est pas une ligne droite, c'est une suite de constructions. J'ai commencé ma vie professionnelle sur le terrain, où la rigueur n'est pas une option mais une nécessité. De l'ébénisterie au transport routier, puis à la menuiserie d'agencement, j'ai forgé mon autonomie et ma capacité à m'adapter à des environnements exigeants.")
        }

        // --- 2ème Partie (Conditionnelle) ---
        if (isExpanded) {
            Div({ classes("mt-6") }) {
                H3Custom("font-bold", "text-lg", "mb-2") {
                    Text("Pourquoi le développement ?")
                }
                P({ classes("text-base", "leading-relaxed", "mb-4") }) {
                    Text("Parce que j'y ai trouvé la satisfaction de bâtir dans un univers qui me challenge au quotidien. Ma transition vers le développement Android, puis vers l'écosystème Kotlin Multiplatform (KMP), est le fruit d'une volonté : celle de progresser sans cesse et de maîtriser des architectures modernes et robustes.")
                }

                P({ classes("text-base", "leading-relaxed") }) {
                    Text("Aujourd'hui, ma double compétence Mobile et Backend (Ktor) me permet de concevoir des solutions technologiques aussi précises qu'un plan de menuiserie et aussi fiables qu'une logistique de transport. Je ne me contente pas de coder ; je bâtis des outils performants, pensés pour l'utilisateur final.")
                }
            }
        }

        // --- Bouton de bascule ---
        if (!isExpanded) {
            Button({
                classes("text-brandPrimary", "font-bold", "text-left", "hover:underline", "w-max", "mt-2", "pt-4")
                onClick { isExpanded = !isExpanded }
            }) {
                Text("En savoir plus ↓")
            }
        } else {
            Button({
                classes("text-sm", *AppColors.textSecondary, "hover:underline", "pt-4")
                onClick { isExpanded = !isExpanded }
            }) {
                Text("↑ Refermer")
            }
        }
    }
}