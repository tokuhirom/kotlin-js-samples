plugins {
    kotlin("multiplatform") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

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

repositories {
    mavenCentral()
}
