plugins {
    kotlin("multiplatform") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

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
                implementation("dev.fritz2:core:1.0-RC19.5")
            }
        }
    }
}

repositories {
    mavenCentral()
}
