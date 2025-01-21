plugins {
    kotlin("multiplatform") version "2.0.10"
}

kotlin {
    js {
        browser {
            binaries.executable()
            commonWebpackConfig {
                cssSupport {
                    enabled = true
                }
            }
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:2025.1.5"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")

                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-base")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-icons-material")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-lab")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-material")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-mui-system")
            }
        }
    }
}
