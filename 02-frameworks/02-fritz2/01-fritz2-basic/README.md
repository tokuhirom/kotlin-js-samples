# 02-fritz2/01-fritz2-basic

Fritz2 は Kotlin/JS のためのリアクティブ Web フレームワークです。
Kotlin/JS のために最適化されているため、とても書きやすいです。

kotlinx.html のような DSL で HTML を書くことができます。
また、リアクティブなプログラミングが得意なため、状態管理がしやすいです。

Router も組み込まれていて、SPA を作るのにも適しています。

## インストール

`build.gradle.kts` に以下のように追記します。

```kotlin
implementation("dev.fritz2:core:1.0-RC17")
```

## ルーター

ルーターが組み込まれているのが特徴の一つでしょう。
ルーターは以下のように記述します。

ルーターは location.hash で管理されます。

```kotlin
import dev.fritz2.routing.routerOf

val router = routerOf(mapOf(
    "page" to "home" // "home" is the default page.
))

render {
    router.select("page").render { (value, _) ->
        when (value) {
            "home" -> {
                div {
                    h1 {
                        +"Home"
                    }
                    p {
                        +"This is the home page."
                    }
                }
            }
            "about" -> {
                div {
                    h1 {
                        +"About"
                    }
                    p {
                        +"This is the about page."
                    }
                }
            }
            "contact" -> {
                div {
                    h1 {
                        +"Contact"
                    }
                    p {
                        +"This is the contact page."
                    }
                }
            }
            else ->
                div("card-body") {
                    h5("card-title") {
                        +"Page not found"
                    }
                }
        }
    }
}
```

上記の例では

```kotlin
val router = routerOf(mapOf(
    "page" to "home" // "home" is the default page.
))
```

としているため、page parameter のデフォルト値が "home" になります。
よって、home のページがデフォルトでは表示されるということです。

