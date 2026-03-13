package fr.anthony.abkweb.data

import fr.anthony.abkweb.model.Feature
import fr.anthony.abkweb.router.Page

val featureList = listOf(

    // BLOC 1 : L'Expertise
    Feature(
        title = "Unification Native : iOS, Android et Web",
        description = "Ne choisissez plus entre performance, rapidité de déploiement et maîtrise des coûts. Je conçois des applications unifiées sur un seul code source Kotlin robuste. Vos utilisateurs bénéficient d'une expérience native fluide sur iOS, Android et tout navigateur web.",
        ctaText = "Découvrir mon approche KMP →",
        onCtaClick = Page.EXPERTISE,
        listOf("home_kmp_visual.webp")
    ),

    // BLOC 2 : La solution FSM
    Feature(
        title = "Solution FSM : Le futur de vos interventions terrain",
        description = "Fini le papier et les processus déconnectés. Je développe actuellement une solution Field Service Management, pensée pour améliorer l'efficacité opérationnelle sur le terrain.",
        ctaText = "Voir la roadmap 2027 →",
        onCtaClick = Page.FSM,
        listOf("home_logo_fsm.webp")
    ),

    // BLOC 3 : L'Humain & Les Projets
    Feature(
        title = "Le développeur derrière le code",
        description = "De l'industrie au développement logiciel : un parcours atypique. Aujourd'hui, je développe des solutions numériques durables avec des technologies modernes.",
        ctaText = "Découvrir mon parcours et mes projets →",
        onCtaClick = Page.PORTFOLIO,
        listOf("home_dev_avatar.webp")
    )
)