plugins {
    kotlin("multiplatform") version "1.9.24"
    id("org.jetbrains.compose") version "1.6.10"
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

                implementation("app.softwork:routing-compose:0.2.14")
            }
        }
    }
}
