plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    jvmToolchain(17)

    js {
        browser {
            // Optionnel : Configurer proprement le nom du bundle
            commonWebpackConfig {
                outputFileName = "composeApp.js"
            }
        }
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(compose.html.core)
            implementation(compose.runtime)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

tasks.register("prepareGitHubPages") {
    group = "distribution"
    description = "Prépare les fichiers spécifiques (404 et CNAME) pour le déploiement GitHub Pages"

    val distLayout = layout.buildDirectory.dir("dist/js/productionExecutable")

    doLast {
        // 2. On récupère la valeur concrète ici
        val distDir = distLayout.get().asFile
        val indexFile = File(distDir, "index.html")
        val fallbackFile = File(distDir, "404.html")
        val cnameFile = File(distDir, "CNAME")

        if (indexFile.exists()) {
            indexFile.copyTo(fallbackFile, overwrite = true)
            cnameFile.writeText("abknative.fr")

            println("[Build] Préparation GitHub Pages terminée :")
            println("- 404.html généré")
            println("- CNAME généré pour abknative.fr")
        } else {
            println("[Build] index.html introuvable dans : ${distDir.absolutePath}")
        }
    }
}

// On lie cette tâche à la distribution finale
tasks.named("jsBrowserDistribution") {
    finalizedBy("prepareGitHubPages")
}