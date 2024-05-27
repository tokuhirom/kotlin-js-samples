package org.example

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
