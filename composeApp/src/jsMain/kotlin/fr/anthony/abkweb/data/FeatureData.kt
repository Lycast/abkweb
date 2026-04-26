package fr.anthony.abkweb.data

import fr.anthony.abkweb.model.Feature
import fr.anthony.abkweb.router.Page

val featureList = listOf(

    // BLOC 1 : L'Expertise
    Feature(
        title = "La puissance de Kotlin Multiplatform",
        description = "Développer pour plusieurs plateformes demande souvent de choisir entre un code hybride (moins performant) ou des équipes séparées (plus chères). Mon expertise Kotlin Multiplatform (KMP) brise cette règle en fusionnant l'efficacité d'un code partagé et la puissance du vrai natif.",
        ctaText = "Découvrir mon approche KMP →",
        onCtaClick = Page.EXPERTISE,
        listOf("home_kmp_visual.webp")
    ),

    // BLOC 2 : Outgo
    Feature(
        title = "Outgo : Maîtrisez vos finances",
        description = "Dites adieu aux fichiers Excel et à l'angoisse des fins de mois. Avec Outgo, reprenez le contrôle de votre budget grâce à la méthode des enveloppes. Simple, visuel et 100% gratuit.",
        ctaText = "Découvrir Outgo →",
        onCtaClick = Page.OUTGO,
        listOf("ss_outgo_00.webp")
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