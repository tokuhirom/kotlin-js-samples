plugins {
    kotlin("multiplatform") version "1.9.23"
}

kotlin {
    js {
        browser {
            useCommonJs()
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
                implementation("dev.fritz2:core:1.0-RC17")
                implementation(npm("bootstrap", "5.1.0"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
