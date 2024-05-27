plugins {
    kotlin("multiplatform") version "1.9.24"
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
                implementation(npm("bootstrap", "5.1.0"))
            }
        }
    }
}
