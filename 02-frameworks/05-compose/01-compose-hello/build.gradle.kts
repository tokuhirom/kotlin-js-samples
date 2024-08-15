plugins {
    kotlin("multiplatform") version "2.0.10"
    id("org.jetbrains.compose") version "1.6.11"
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.10"
}

kotlin {
    js {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
            binaries.executable()
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                // compose.html.core などは org.jetbrains.compose plugin が提供している。
                implementation(compose.html.core)
                implementation(compose.runtime)
            }
        }
    }
}
