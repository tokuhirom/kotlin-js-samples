# 05-compose/01-compose-hello

Compose for Web を使って、Hello, World を表示するサンプルです。

https://github.com/JetBrains/compose-multiplatform/tree/master/tutorials/HTML/Getting_Started

以下のようにして実行できます。

```
./gradlew :02-frameworks:05-compose:01-compose-hello:jsRun -t
```

以下のように書いてセットアップします。

```
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
            }
        }
    }
}
```

