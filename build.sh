#!/bin/bash
# Assurer que le script Gradle est exécutable
chmod +x gradlew
# Définir la version de Java à 17
export JAVA_VERSION=17
# Lancer la construction Kotlin/Gradle (la commande la plus simple)
./gradlew :webTest:jsJar
# Le script doit réussir pour que Netlify continue
