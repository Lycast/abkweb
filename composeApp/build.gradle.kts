plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {

    jvmToolchain(17)

    js {
        browser()
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


