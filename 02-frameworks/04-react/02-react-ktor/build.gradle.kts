plugins {
    kotlin("multiplatform") version "2.0.10"
    kotlin("plugin.serialization") version "2.0.20"
}

kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.795"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                implementation(project.dependencies.platform("io.ktor:ktor-bom:2.3.12"))
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
