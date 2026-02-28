package fr.anthony.abkweb.pages

import androidx.compose.runtime.Composable
import fr.anthony.abkweb.components.*
import fr.anthony.abkweb.router.Page
import fr.anthony.abkweb.theme.AppColors
import org.jetbrains.compose.web.attributes.alt
import org.jetbrains.compose.web.dom.*

@Composable
fun Home(
    onNavigate: (Page) -> Unit
) {
    // On retire le padding-top du main ici car il est déjà géré par le squelette si besoin
    // Mais on garde un conteneur qui centre tout verticalement pour le Hero
    Div({ classes("flex-grow", "w-full", "flex", "flex-col", *AppColors.bgMain) }) {

        // BANNIÈRE
        //Banner()


        AppSection {

            // --- 1. SECTION HERO ---
            Div({ classes("text-center", "animate-fade-in") }) {

                // Un petit badge au-dessus du titre pour le côté "SaaS"
                Span({
                    classes(
                        "inline-block",
                        "px-4", "py-1.5",
                        "mb-6",
                        "text-sm", "font-bold", "tracking-wider",
                        "rounded-full",
                        // COULEURS :
                        "text-brandAccent",      // Texte en Or
                        "bg-brandAccent/10",     // Fond en Or avec 10% d'opacité
                        "border", "border-brandAccent/20" // Optionnel : une petite bordure pour plus de relief
                    )
                }) {
                    Text("DISPONIBLE AVRIL 2026")
                }

                H1Custom(extraClasses = arrayOf("mb-6")) {
                    Text("L'architecture ")
                    TextHighlight(colorClass = AppColors.accent) { Text("Kotlin Multiplatform") }
                    Br()
                    Text("au service de votre métier")
                }

                BodyText(extraClasses = arrayOf("max-w-2xl", "mx-auto", "mb-10")) {
                    Text("Développeur Fullstack spécialisé KMP. Je conçois des applications mobiles et web unifiées avec un seul code source pour une performance native.")
                }
            }

            // --- 2. BLOCS NARRATIFS ---
            Div({ classes("flex", "flex-col", "w-full", "animate-fade-in-up") }) {

                // BLOC 1 : L'Expertise (Image à droite par défaut)
                FeatureBlock(
                    title = "Unification Native : iOS, Android et Web", // Titre mis à jour pour inclure le Web
                    description = "Ne choisissez plus entre performance, portée et coûts de développement. Je conçois des applications unifiées sur un seul code source Kotlin robuste. Vos utilisateurs bénéficient d'une expérience native fluide sur ios, android et n'importe quel navigateur.",
                    ctaText = "Découvrir mon approche KMP →",
                    onCtaClick = { onNavigate(Page.EXPERTISE) },
                    isReversed = false
                ) {
                    Div({
                        classes(
                            "w-full",
                            "max-w-2xl", // Permet d'avoir une image assez large mais contenue
                            "md:h-[400px]",
                            "h-[300px]", // 400px sur grand écran, 300px sur mobile
                            "flex",
                            "justify-center",
                            "items-center",
                            "bg-surfaceLight",
                            "dark:bg-surfaceDark",
                            "rounded-2xl", // On garde le fond de carte pour le relief
                            "p-4",
                            "border",
                            "border-slate-800" // Un peu de padding pour le visuel
                        )
                    }) {
                        Img(src = "home_kmp_visual.png", attrs = {
                            classes("w-full", "h-full", "object-contain")
                            alt("Composition KMP : Application unifiée sur iPhone, Android et Desktop Web")
                        })
                    }
                }

                // BLOC 2 : Le Produit FSM (Image à gauche)
                FeatureBlock(
                    title = "Solution FSM : Le futur de vos interventions terrain",
                    description = "Fini le papier et les processus déconnectés. Je développe actuellement une solution Field Service Management, pensée pour améliorer l'efficacité opérationnelle sur le terrain.",
                    ctaText = "Voir la roadmap 2027 →",
                    onCtaClick = { onNavigate(Page.FSM) },
                    isReversed = true // <-- Alterne le sens de lecture
                ) {
                    Div({
                        classes(
                            "w-full",
                            "max-w-2xl", // Permet d'avoir une image assez large mais contenue
                            "md:h-[400px]",
                            "h-[300px]", // 400px sur grand écran, 300px sur mobile
                            "flex",
                            "justify-center",
                            "items-center",
                            "bg-surfaceLight",
                            "dark:bg-surfaceDark",
                            "rounded-2xl", // On garde le fond de carte pour le relief
                            "p-4",
                            "border",
                            "border-slate-800" // Un peu de padding pour le visuel
                        )
                    }) {
                        Img(src = "home_logo_fsm.png", attrs = {
                            classes("w-full", "h-full", "object-contain")
                            alt("K Native FSM")
                        })
                    }
                }

                // BLOC 3 : L'Humain & Les Projets (Image à droite)
                FeatureBlock(
                    title = "Le développeur derrière le code",
                    description = "De l'industrie au développement logiciel : un parcours atypique au service de la performance. Aujourd'hui, je conçois des solutions durables avec des technologies modernes comme Kotlin Multiplatform (KMP).",
                    ctaText = "Découvrir mon parcours et mes projets →",
                    onCtaClick = { onNavigate(Page.PORTFOLIO) },
                    isReversed = false
                ) {
                    Div({
                        classes(
                            "w-full",
                            "max-w-2xl", // Permet d'avoir une image assez large mais contenue
                            "md:h-[400px]",
                            "h-[300px]", // 400px sur grand écran, 300px sur mobile
                            "flex",
                            "justify-center",
                            "items-center",
                            "bg-surfaceLight",
                            "dark:bg-surfaceDark",
                            "rounded-2xl", // On garde le fond de carte pour le relief
                            "p-4",
                            "border",
                            "border-slate-800" // Un peu de padding pour le visuel
                        )
                    }) {
                        Img(src = "home_dev_avatar.png", attrs = {
                            classes("w-full", "h-full", "object-contain")
                            alt("Avatar")
                        })
                    }
                }
            }
        }
    }
}