package fr.anthony.abkweb.data

import fr.anthony.abkweb.models.Project

// Cette liste est accessible depuis n'importe où dans ton code
val myProjectsList = listOf(
    Project(
        id = "kmp-quiz",
        title = "KMP Quiz Demo - Application de Quiz en Temps Réel",
        shortDescription = "Ce projet est une démonstration technique d'une application de quiz interactive en temps réel, conçue avec Kotlin Multiplatform (KMP).\n" +
                "Il met en avant une architecture Kotlin full-stack, permettant le partage de code entre un backend Ktor, une application mobile Android et un panneau d'administration Compose for Web.\n" +
                "Le système permet à un administrateur de gérer les sessions de quiz depuis un tableau de bord web, tandis qu'un joueur participe via une application Android, le tout synchronisé en temps réel.",
        fullDescription =
                    "Fonctionnalités Principales :\n" +
                    "- Tableau de Bord Admin (Web) : Créer et gérer des sessions de quiz, suivre les réponses des joueurs en direct et consulter les statistiques.\n" +
                    "- Application Joueur (Android) : Rejoindre une session, répondre aux questions et obtenir son score en temps réel.\n" +
                    "Synchronisation en Temps Réel : Les vues joueur et admin sont synchronisées via WebSockets pour les mises à jour en direct et par polling HTTP pour les statistiques.\n" +
                    "Stack Technique & Architecture\n" +
                    "Ce projet démontre une approche Kotlin full-stack moderne.\n" +
                    "\n" +
                    "Points Techniques \n" +
                    "Partage de Code Maximal : La logique métier, les couches réseau et les ViewModels sont partagés entre toutes les plateformes.\n" +
                    "Programmation Réactive : Utilisation de Coroutines & Flow pour les opérations asynchrones et les flux de données.\n" +
                    "Full-Stack Kotlin : Démontre la puissance d'utiliser un langage unique pour l'ensemble de la stack technologique.",
        techStack = "Logique Partagée: Kotlin Multiplatform\n" +
                "ViewModels (MVI), Ktor Client, callbackFlow pour WebSockets, Koin pour l'injection de dépendances (DI).\n" +
                "\n" +
                "Backend : Ktor\n" +
                "API REST, WebSockets, Exposed + SQLite pour la persistance.\n" +
                "\n" +
                "App Android : Jetpack Compose\n" +
                "UI côté joueur, connectée au module partagé.\n" +
                "App Web : Compose for Web\n" +
                "UI du tableau de bord admin, également connectée au module partagé.\n",
        githubUrl = "https://github.com/Lycast/KMP-Demo",
        images = listOf("ss_kmp_quiz_00.png", "ss_kmp_quiz_01.png", "ss_kmp_quiz_02.png", "ss_kmp_quiz_03.png")
    ),


    Project(
        id = "portfolio-abk-native",
        title = "ABK Native - Portfolio Expert KMP",
        shortDescription = "Mon site web personnel développé de A à Z avec Kotlin Multiplatform (KMP) et Compose HTML, démontrant des performances web de niveau natif.\n" +
                "Ce projet contient le code source de mon portfolio (abknative.fr).\n" +
                "Construit entièrement depuis zéro, il illustre comment obtenir des performances web optimales tout en conservant une base de logique Kotlin robuste et partagée.",
        fullDescription =
                "Fonctionnalités Clés :\n" +
                "- Développement Unifié : Architecture KMP moderne exploitant les cibles `webMain` et `wasmJs`.\n\n" +
                "- Routage Prêt pour la Production : Routeur SPA (Single Page Application) sur-mesure. Il gère l'accès direct aux URLs et l'historique du navigateur (popstate) via une logique de redirection intelligente sur une page 404.html.\n\n" +
                "- Expérience Utilisateur (UX) : Mode sombre/clair dynamique synchronisé avec le système de l'utilisateur, et transitions de thème fluides (500ms à 1000ms).\n\n" +
                "- Déploiement Automatisé : Pipeline CI/CD qui génère et livre automatiquement les builds statiques sur GitHub Pages, le tout relié à un nom de domaine personnalisé OVH.",
        techStack = "Moteur Principal : Kotlin Multiplatform (KMP) - Logique unifiée cross-platform.\n" +
                "Framework UI : Compose HTML - Interface web réactive construite à 100% en Kotlin.\n" +
                "Style : Tailwind CSS - Approche utilitaire pour un design responsive et \"Pixel Perfect\".\n" +
                "Infrastucture : GitHub Actions (CI/CD), GitHub Pages, OVH.",
        githubUrl = "https://github.com/Lycast/abkweb",
        images = listOf(
            "logo_abknative.png"
        )
    ),


    Project(
        id = "hubnote-checklist-compose",
        title = "HUBNOTE ChecklistCompose - Gestionnaire de Tâches Android",
        shortDescription = "Application Android native moderne pour la gestion de listes de tâches, conçue avec une architecture multi-modules propre et les dernières bibliothèques Jetpack.\n" +
                "ChecklistCompose est une application Android conçue dès le départ pour être robuste, évolutive et facile à maintenir.\n" +
                "L'objectif principal de ce projet est d'appliquer et de démontrer les meilleures pratiques de développement Android professionnel actuel.",
        fullDescription =
                "✨ Vision & Principes Fondamentaux :\n" +
                "- Évolutivité : Une architecture multi-modules découplée qui permet d'ajouter de nouvelles fonctionnalités avec un minimum d'effets de bord.\n" +
                "- Maintenabilité : Un code propre, lisible et documenté qui suit le guide de style officiel de Kotlin.\n\n" +
                "🏗️ Architecture Multi-Modules (Règle d'indépendance stricte) :\n" +
                "Le projet suit une règle de dépendance unidirectionnelle stricte (app → feature → core) pour éviter les dépendances cycliques.\n\n" +
                "- Module :app : Point d'entrée principal. Assemble les modules, configure l'injection (Hilt) et définit le graphe de navigation global.\n" +
                "- Module :feature_checklist : Tranche fonctionnelle indépendante contenant les écrans, les ViewModels et la logique spécifique aux listes.\n" +
                "- Module :core:domain : Cœur de la logique métier (modèles, règles, interfaces). Module Kotlin pur, sans dépendances au framework Android.\n" +
                "- Module :core:data : Implémentation de la couche de données (Base de données Room, DAOs, Repositories).\n" +
                "- Module :core:ui : Bibliothèque UI partagée contenant les composants @Composable réutilisables et le thème de l'application.",
        techStack = "UI : Jetpack Compose (Material 3 design)\n" +
                "Architecture : Clean Architecture, Multi-modules, MVVM\n" +
                "Injection de Dépendances : Hilt\n" +
                "Base de données : Room\n" +
                "Asynchrone & Réactivité : Kotlin Coroutines & Flow\n" +
                "Navigation : Navigation Compose",
        githubUrl = "https://github.com/Lycast/HubNote",
        images = listOf("ss_hubnote_00.png", "ss_hubnote_01.png", "ss_hubnote_02.png", "ss_hubnote_03.png")
    ),

    Project(
        id = "score-counter-android",
        title = "Score Counter - Gestionnaire de Scores",
        shortDescription = "Mon tout premier projet personnel Android natif, conçu pour le suivi de scores multijoueurs. Il démontre une maîtrise de la stack Android UI classique.\n" +
                "Il s'agit d'une application complète permettant de gérer des scores pour divers jeux (Solo, Liste, Tournoi) avec sauvegarde locale.",
        fullDescription =
                "Ce projet démontre ma capacité à travailler sur des bases de code Android traditionnelles, encore très présentes en entreprise, avant ma transition vers Jetpack Compose.\n\n" +
                "🎯 Fonctionnalités Clés :\n" +
                "- Modes de jeu multiples : Gestion de compteurs simples, de listes de joueurs et d'un système de tournoi complet.\n" +
                "- Personnalisation et Outils : Lancer de dés virtuel intégré, personnalisation visuelle des joueurs (nom/couleur).\n" +
                "- Persistance : Sauvegarde et chargement de sessions de jeu pour ne jamais perdre sa progression.",
        techStack = "Architecture : MVVM (Google Architecture Components)\n" +
                "Interface Utilisateur : XML, ViewBinding, Fragments, ViewPager2, RecyclerView, Material Design\n" +
                "Base de données : Room (SQLite)\n" +
                "Asynchrone : Kotlin Coroutines & LiveData",
        githubUrl = "https://github.com/Lycast/PointCounter", // Remplace par ton lien
        images = listOf("ss_scorecounter_00.png", "ss_scorecounter_01.png", "ss_scorecounter_02.png")
    ),


    Project(
        id = "go4lunch-android",
        title = "Go4Lunch - Application Sociale d'Entreprise",
        shortDescription = "Une application Android collaborative permettant aux collègues de bureau de trouver, choisir et se retrouver dans un restaurant pour la pause déjeuner.\n" +
                "Développée dans le cadre de ma formation de développeur d'applications Android, Go4Lunch est une solution sociale d'entreprise intégrant des services de cartographie et un backend cloud (BaaS).",
        fullDescription =
                "Fonctionnalités Principales :\n" +
                "- Cartographie et Recherche : Visualisation des restaurants environnants sur une carte interactive (Google Maps API) ou sous forme de liste, avec moteur de recherche intégré.\n" +
                "- Fiches Détaillées : Consultation des informations complètes du restaurant (horaires, adresse) et possibilité de déclencher un appel direct pour réserver une table.\n" +
                "- Aspect Social : Suivi en temps réel des choix de déjeuner des autres collègues pour faciliter les rencontres et la cohésion d'équipe.\n" +
                "- Notifications Push : Envoi d'un rappel automatique avant l'heure du repas indiquant le restaurant choisi et les collègues participants.",
        techStack = "Architecture : MVVM\n" +
                "Backend (BaaS) : Firebase (Authentication, Cloud Firestore, Cloud Storage)\n" +
                "Réseau & API : Retrofit, Gson, Google Maps SDK, Places API\n" +
                "UI & Médias : ViewBinding, Glide\n" +
                "Tests : Mockito, Espresso",
        githubUrl = "https://github.com/Lycast/Go4Lunch", // N'oublie pas de mettre ton vrai lien
        images = listOf("ss_go4lunch_00.png", "ss_go4lunch_01.png", "ss_go4lunch_02.png", "ss_go4lunch_03.png", "ss_go4lunch_04.png", "ss_go4lunch_05.png"
        )
    )
)