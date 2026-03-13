package fr.anthony.abkweb.data

import fr.anthony.abkweb.model.Expertise

val expertise = listOf(
    // Carte 1 : Logique Partagée
    Expertise(
        title = "Logique Métier Unifiée",
        description = "Mutualisation des règles métier, des modèles de données et de la logique réseau. Un seul code source Kotlin à tester et à maintenir pour iOS, Android et Web, réduisant drastiquement la dette technique et les bugs."
    ),
    // Carte 2 : Backend Ktor
    Expertise(
        title = "Backend Ktor & API",
        description = "Création d'infrastructures serveurs légères et ultra-performantes 100% Kotlin. Développement d'API RESTful robustes et gestion de la synchronisation en temps réel via WebSockets."
    ),
    // Carte 3 : NOUVELLE CARTE MIGRATION
    Expertise(
        title = "Modernisation & Migration KMP",
        description = "Audit et refactoring progressif d'applications natives existantes. Introduction de Kotlin Multiplatform en douceur pour partager la logique métier étape par étape, sans avoir à réécrire l'interface utilisateur ou perturber la production."
    )
)