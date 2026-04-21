package fr.anthony.abkweb.data

import fr.anthony.abkweb.model.Project

val myProjectsList = listOf(

    Project(
        id = "outgo-budget",
        title = "Outgo - Offline-First",
        shortDescription = "Une application de gestion de budget. Développée en Kotlin Multiplatform (KMP) avec une philosophie « Offline-First », elle garantit une expérience fluide sans latence et une synchronisation cloud transparente.",
        fullDescription = "**Vision & Fonctionnalités**\n" +
                "- Méthode des enveloppes : Suivi des charges fixes et calcul du reste à vivre en temps réel.\n" +
                "- Synchronisation intelligente : L'interface utilisateur n'attend jamais le réseau. Les actions sont exécutées localement puis orchestrées en arrière-plan avec le cloud.\n" +
                "\n**Défis & Architecture**\n" +
                "Le projet se distingue par une architecture multi-modules ultra-découplée appliquant le pattern API/Implementation pour une inversion de dépendance totale. Plus de 95% de la logique métier est partagée. Le cœur de l'application repose sur un moteur de projection temporelle sur-mesure, capable de transformer des récurrences en un prévisionnel mensuel clair.",
        techStack = "\n**Stack Technique & Architecture**\n" +
                "Kotlin Multiplatform (KMP), Jetpack Compose (Android), SwiftUI (iOS), SQLDelight (Local), PostgreSQL (Cloud), Ktor (Backend Serverless), Koin, Coroutines/Flow, Firebase Auth",
        githubUrl = "https://github.com/Lycast/Outgo",
        images = listOf("ss_outgo_0.webp", "ss_outgo_00.webp", "ss_outgo_01.webp", "ss_outgo_02.webp", "ss_outgo_03.webp", "ss_outgo_04.webp")
    ),

    Project(
        id = "kmp-quiz",
        title = "KMP Quiz Demo",
        shortDescription = "Un quiz interactif synchronisé en temps réel. Il illustre la puissance du partage de code KMP entre un backend Ktor, une app Android et un dashboard web. Je l'ai développé dans le but de faire la démonstration de la stack lors d'un salon",
        fullDescription = "**Fonctionnalités Principales**\n" +
                    "- Admin (Web) : Création de sessions, suivi des réponses en direct et statistiques.\n" +
                    "- Joueur (Android) : Participation et suivi du score en temps réel.\n" +
                    "- Synchronisation : Actualisation en direct via WebSockets et polling HTTP.\n" +
                    "\n**Défis & Architecture**\n" +
                    "L'objectif de ce projet est de maximiser le partage de code. La logique métier, les couches réseau et les ViewModels (MVI) sont partagés entre toutes les cibles. L'utilisation de Coroutines et Flow permet de gérer de manière fluide et réactive les flux de données asynchrones.",
        techStack = "\n**Stack Technique & Architecture**\n" +
                "KMP, Ktor (Client/Serveur), Jetpack Compose, Compose HTML, WebSockets, Koin, SQLite (Exposed)",
        githubUrl = "https://github.com/Lycast/KMP-Demo",
        images = listOf("ss_kmp_quiz_00.webp", "ss_kmp_quiz_01.webp", "ss_kmp_quiz_02.webp", "ss_kmp_quiz_03.webp")
    ),


    Project(
        id = "portfolio-abk-native",
        title = "ABK Native - site web",
        shortDescription = "Les coulisses de ce site web. Développé de zéro avec Kotlin Multiplatform et Compose HTML, il démontre qu'il est possible d'obtenir des performances web optimales avec une logique 100% Kotlin.",
        fullDescription = "**Points Techniques**\n" +
                    "- Développement Unifié : Architecture KMP moderne exploitant la cible `jsMain`.\n" +
                    "- Routage Custom : Routeur SPA (Single Page Application) sur-mesure gérant l'accès direct aux URLs et l'historique (popstate) via redirection.\n" +
                    "- UX & Design : Mode sombre/clair dynamique synchronisé avec le système et transitions fluides.\n" +
                    "- CI/CD : Déploiement automatisé des builds statiques sur GitHub Pages via GitHub Actions, relié à un domaine OVH.",
        techStack = "\n**Stack Technique & Architecture**\n" +
                    "Kotlin Multiplatform (jsMain), Compose HTML, Tailwind CSS, GitHub Actions, GitHub Pages, OVH",
        githubUrl = "https://github.com/Lycast/abkweb",
        images = listOf("logo_abknative.webp")
    ),


    Project(
        id = "hubnote-checklist-compose",
        title = "HUBNOTE ChecklistCompose - Gestionnaire de Tâches",
        shortDescription = "Une application Android de gestion de tâches conçue pour la scalabilité. Elle met en pratique les standards actuels de l'industrie : Clean Architecture, Multi-modules et Jetpack Compose.",
        fullDescription = "**Vision & Principes Fondamentaux**\n" +
                    "- Évolutivité : Architecture multi-modules découplée permettant d'ajouter des fonctionnalités avec un minimum d'effets de bord.\n" +
                    "- Maintenabilité : Code propre, lisible et documenté suivant les standards officiels Kotlin.\n" +
                    "\n**Architecture Multi-Modules**\n" +
                    "Le projet suit une règle de dépendance unidirectionnelle stricte (app → feature → core) pour éviter les dépendances cycliques :\n" +
                    "- `:app` : Assemble les modules, configure l'injection (Hilt) et le graphe de navigation.\n" +
                    "- `:feature_checklist` : Tranche fonctionnelle indépendante (écrans, ViewModels, logique UI).\n" +
                    "- `:core:domain` : Cœur de la logique métier (Kotlin pur, sans framework Android).\n" +
                    "- `:core:data` : Implémentation de la couche de données (Base Room, DAOs, Repositories).\n" +
                    "- `:core:ui` : Composants `@Composable` réutilisables et thème global.",
        techStack = "\n**Stack Technique & Architecture**\n" +
            "Jetpack Compose (Material 3), Clean Architecture, Multi-modules, MVVM, Hilt, Room, Coroutines & Flow, Navigation Compose",
        githubUrl = "https://github.com/Lycast/HubNote",
        images = listOf("ss_hubnote_00.webp", "ss_hubnote_01.webp", "ss_hubnote_02.webp", "ss_hubnote_03.webp")
    ),

    Project(
        id = "score-counter-android",
        title = "Score Counter - Gestionnaire de Scores",
        shortDescription = "Une application Android native pour le suivi de scores et la gestion de tournois. Elle prouve ma capacité à travailler sur la stack UI Android classique (XML), une compétence indispensable pour maintenir les bases de code existantes en entreprise.",
        fullDescription = "**Fonctionnalités Principales**\n" +
                    "- Modes de jeu multiples : Gestion de compteurs simples, de listes de joueurs et d'un système de tournoi complet.\n" +
                    "- Outils intégrés : Lancer de dés virtuel et personnalisation visuelle des participants (nom et couleur).\n" +
                    "- Persistance des données : Sauvegarde et rechargement de sessions de jeu pour ne jamais perdre l'historique d'une partie.",
        techStack = "\n**Stack Technique & Architecture**\n" +
                "MVVM, XML, ViewBinding, Fragments, ViewPager2, RecyclerView, Material Design, Room (SQLite), Coroutines, LiveData",
        githubUrl = "https://github.com/Lycast/PointCounter",
        images = listOf("ss_scorecounter_00.webp", "ss_scorecounter_01.webp", "ss_scorecounter_02.webp")
    ),


    Project(
        id = "go4lunch-android",
        title = "Go4Lunch - Application Sociale d'Entreprise",
        shortDescription = "Une application Android collaborative (Java/XML) pour organiser les déjeuners entre collègues. Développée lors de ma formation initiale, elle prouve ma capacité à intégrer une cartographie (Google Maps) et un backend cloud (Firebase) sur une base de code historique.",
        fullDescription = "**Fonctionnalités Principales**\n" +
                    "- Cartographie : Visualisation des restaurants environnants sur carte interactive (Google Maps API) et recherche intégrée.\n" +
                    "- Fiches Détaillées : Informations complètes des établissements (horaires, adresses) et appels directs pour réserver.\n" +
                    "- Aspect Social : Suivi en temps réel des choix de déjeuner des autres collaborateurs pour faciliter les rencontres.\n" +
                    "- Notifications : Rappel push automatique avant le repas récapitulant le lieu choisi et les participants.",
        techStack = "\n**Stack Technique & Architecture**\n" +
                "Java, XML, MVVM, Firebase (Auth, Firestore, Storage), Retrofit, Gson, Google Maps SDK, Places API, ViewBinding, Glide, Mockito, Espresso",
        githubUrl = "https://github.com/Lycast/Go4Lunch",
        images = listOf("ss_go4lunch_00.webp", "ss_go4lunch_01.webp", "ss_go4lunch_02.webp", "ss_go4lunch_03.webp", "ss_go4lunch_04.webp", "ss_go4lunch_05.webp"
        )
    )
)