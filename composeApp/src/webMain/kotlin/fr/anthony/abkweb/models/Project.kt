package fr.anthony.abkweb.models

data class Project(
    val id: String,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val techStack: String,
    val githubUrl: String?,
    val images: List<String>
)