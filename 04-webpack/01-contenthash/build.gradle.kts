plugins {
    kotlin("multiplatform") version "2.0.0"
}

kotlin {
    js {
        browser {
            binaries.executable()
            webpackTask {
                mainOutputFileName = "web.[contenthash].js"
            }
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(devNpm("html-webpack-plugin", "5.5.0"))
            }
        }
    }
}

tasks.named<ProcessResources>("jsProcessResources") {
    exclude("index.html")
}
