plugins {
    kotlin("multiplatform") version "2.0.10"
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
