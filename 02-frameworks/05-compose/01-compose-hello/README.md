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

compose のコードは以下のようになります。

```kotlin
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable

fun main() {
    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div {
            Text("$count")
        }
        Div {
            Button(attrs = {
                onClick { count -= 1 }
            }) {
                Text("Decrement")
            }

            Button(attrs = {
                onClick { count += 1 }
            }) {
                Text("Increment")
            }
        }
    }
}
```
