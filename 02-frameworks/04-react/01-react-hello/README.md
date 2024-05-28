# 04-react/01-react-hello

kotlin-wrappers の一コンポーネントとして kotlin-react-dom は提供されています。

https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react-dom

kotlin-react-dom は、types-kotlin により生成されています。

## セットアップ

```kotlin
kotlin {
    js {
        browser {
            binaries.executable()
        }
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.754"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
            }
        }
    }
}
```

とするだけです。
依存の追加だけなので簡単ですね。

## コード

実装は以下のようになる。
基本的には react のコンポーネントを作成しているだけです。

```kotlin
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.h1
import web.dom.document

fun main() {
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    createRoot(container).render(Fragment.create {
        h1 {
            +"Hello, React+Kotlin/JS!"
        }
    })
}
```

kotlin-react の最大の利点は react だということです。
react の開発はまだまだ当分続きそうですし、ドキュメントも豊富です。

一方で、react 自体が進歩し続けているため、キャッチアップがある程度必要でしょう。
react の周辺ライブラリも多く、キャッチアップに少しだけ手間がかかります。
