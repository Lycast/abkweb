package fr.anthony.abkweb.models

data class Project(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val techStack: String, // Ou une List<String> si tu veux faire des "puces" (badges) par techno
    val githubUrl: String?, // Nullable au cas où un projet ne soit pas open-source
    val images: List<String> // Les URLs ou chemins locaux pour le futur carrousel
)