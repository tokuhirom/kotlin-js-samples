plugins {
    kotlin("multiplatform") version "2.0.10"
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
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
