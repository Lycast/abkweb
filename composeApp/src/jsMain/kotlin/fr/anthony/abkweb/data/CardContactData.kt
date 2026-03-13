package fr.anthony.abkweb.data

import fr.anthony.abkweb.model.Contact

val contacts = listOf(
    // Carte 1 : EMAIL
    Contact(
        icon = "/icon_mail.webp",
        title = "Par Email",
        description = "Je réponds généralement très rapidement.",
        actionText = "M'écrire un email",
        actionLink = "mailto:contact@abknative.fr"
    ),
    // Carte 2 : LINKEDIN
    Contact(
        icon = "/icon_linkedin.webp",
        title = "LinkedIn",
        description = "Suivez mon actualité professionnelle et mon réseau.",
        actionText = "Voir mon profil",
        actionLink = "https://www.linkedin.com/in/anthony-brenon-a7761b213"
    )
)