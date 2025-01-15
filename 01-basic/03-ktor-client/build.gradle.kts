plugins {
    kotlin("multiplatform") version "2.0.10"
    kotlin("plugin.serialization") version "2.1.0"
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
                implementation(project.dependencies.platform("io.ktor:ktor-bom:3.0.3"))
                implementation("io.ktor:ktor-client-core")
                implementation("io.ktor:ktor-client-js")
                implementation("io.ktor:ktor-serialization-kotlinx-json")
                implementation("io.ktor:ktor-client-content-negotiation")
                implementation("io.ktor:ktor-client-serialization")
                implementation("io.ktor:ktor-client-logging")
                implementation("io.ktor:ktor-client-json")
            }
        }
    }
}
