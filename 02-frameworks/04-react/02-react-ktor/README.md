# 04-react/02-react-ktor

kotlin-react を使う時でも ktor-client を使うと便利です。

ktor-client は suspend 関数を使うため、react の `useEffect` とは相性が悪いですが、
kotlin-react-use に含まれる `useAsyncEffect` を使うことで、簡単に使うことができます。

## セットアップ

JSON を取り出すので、kotlinx.serialization を使うために、`kotlin("plugin.serialization")` を追加します。

```kotlin
plugins {
    kotlin("multiplatform") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
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
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.754"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-use")

                implementation(project.dependencies.platform("io.ktor:ktor-bom:2.3.11"))
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
```

## コード

`useAsyncEffect` を使って、JSON を取得する例です。

```kotlin
package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.fetch.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import org.w3c.fetch.Response
import react.FC
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.use.useAsyncEffect
import react.useEffect
import react.useState
import web.cssom.PropertyName.Companion.container
import web.dom.document
import web.prompts.alert
import kotlin.js.Promise

@Serializable
data class ResponseEntity(val name: String)

val client = HttpClient() {
    install(ContentNegotiation) {
        json()
    }
}

val MyContent = FC {
    val (name, setName) = useState<String?>(null)

    useAsyncEffect {
        val res = client.get("./data.json")
        val data = res.body<ResponseEntity>()
        setName(data.name)
    }

    h1 {
        if (name != null) {
            +"Hello $name"
        } else {
            +"Loading..."
        }
    }
}


fun main() {
    try {
        val container = document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container).render(Fragment.create {
            MyContent()
        })
    } catch (e: Exception) {
        println(e.message ?: "An error occurred")
        alert(e.message ?: "An error occurred")
    }
}
```

## まとめ

react-use はこれ以外にも react 関連の様々な hooks を提供しています。
[react-useで使える便利なReact Hooksを紹介します](https://qiita.com/st_12/items/c4e4c1237e97c1b6a657) などを参照してください。
