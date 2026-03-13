package fr.anthony.abkweb.model

import fr.anthony.abkweb.router.Page

data class Feature(
    val title: String,
    val description: String,
    val ctaText: String,
    val onCtaClick: Page,
    val images: List<String>
)
