# 03-ktor-client

Kotlin/JS からサーバーにアクセスする場合は kotlin-wrappers で提供されてる fetch 関数を使う方法と、ktor-client を使う方法がある。
本項では ktor-client を使う方法を紹介します。

`fetch` を使ってもいいのだけど fetch はちょっと使い勝手が悪いんで、ktor-client を使うことをお勧めします。

ktor は JetBrains が提供している Web フレームワークで、kotlin で書かれています。
サーバーサイドを ktor で書けば、クライアントでもサーバーサイドでも同じ HTTP Client を利用することが出来て便利です。 

client と server の両方を扱う方法については [ktor のサンプル](https://github.com/Kotlin/kotlinx-rpc/tree/main/samples/ktor-web-app) を参考にすると良い。

## インストール

`build.gradle.kts` に以下のように追記します。

```kotlin
implementation(platform("io.ktor:ktor-bom:2.3.11"))
implementation("io.ktor:ktor-client-core")
implementation("io.ktor:ktor-client-js")
implementation("io.ktor:ktor-serialization-kotlinx-json")
implementation("io.ktor:ktor-client-content-negotiation")
implementation("io.ktor:ktor-client-serialization")
implementation("io.ktor:ktor-client-json")

// logging が必要な場合だけ記述してください
implementation("io.ktor:ktor-client-logging")
```

kotlinx.serialization が必要な場合は以下のようにプラグインをロードします。

```kotlin
plugins {
    kotlin("plugin.serialization") version "2.0.0"
}
```

## サンプル

以下のように記述します。
例外が発生した場合、何もエラーが表示されないことがあるので、全体を try-catch で囲った方が良いかもしれません。

```kotlin
package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.serialization.Serializable

@Serializable
data class ResponseEntity(val name: String)

suspend fun main() {
    val client = HttpClient(Js) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            level = LogLevel.INFO
        }
    }

    val res = client.get("./data.json")
    println(res.status.value)
    println("content-type: ${res.contentType()}")

    try {
        val data:ResponseEntity = res.body()
        println(data)

        val div = document.createElement("div")
        div.className = "alert alert-primary"
        div.textContent = "Hello ${data.name}"

        val root = document.getElementById("root")
        root?.clear()
        root?.appendChild(div)
    } catch (e: Exception) {
        println(e)
    }
}
```

## coroutine と ktor-client

ktor-client の API は coroutine を使っているので、suspend 関数です。

例えば kotlin-react-dom の `useEffect` は suspend 関数を受け取れません。
compose-html を使う場合は、suspend 関数を受け取れるので便利です。
