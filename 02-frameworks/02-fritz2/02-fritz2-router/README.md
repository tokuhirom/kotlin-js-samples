# 02-fritz2/02-fritz2-router

Fritz2 は Router も組み込まれていて、SPA を作るのにも適しています。

## ルーター

ルーターは以下のように記述します。

ルーターは location.hash で管理されます。

```kotlin
import dev.fritz2.core.render
import dev.fritz2.routing.routerOf
import kotlinx.coroutines.flow.map

fun main() {
    val router = routerOf(mapOf(
        "page" to "home" // "home" is the default page.
    ))

    render("#root") {
        ul {
            listOf("home", "about", "contact").forEach {page ->
                li {
                    a {
                        className(router.data.map {
                            if (it["page"] == page) "active" else ""
                        })

                        +page.replaceFirstChar { c -> c.uppercaseChar() }
                        clicks.map {
                            mapOf("page" to page)
                        }.handledBy(router.navTo)
                    }
                }
            }
        }

        router.select("page").render {(value, _) ->
            when (value) {
                "home" -> {
                    div {
                        h1 {
                            +"Current page is Home"
                        }
                    }
                }
                "about" -> {
                    div {
                        h1 {
                            +"Current page is About"
                        }
                    }
                }
                "contact" -> {
                    div {
                        h1 {
                            +"Current page is Contact"
                        }
                    }
                }
                else ->
                    div {
                        h5 {
                            +"Page not found"
                        }
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

http://localhost:8083/ にアクセスしたら home のページが表示されます。
いずれかのメニューをタップすると、 http://localhost:8083/#page=about のような URL に遷移します。

