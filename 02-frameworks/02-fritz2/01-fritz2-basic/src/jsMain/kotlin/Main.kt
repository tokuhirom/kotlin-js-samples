package org.example

import dev.fritz2.core.render
import dev.fritz2.routing.routerOf
import kotlinx.coroutines.flow.map

fun main() {
    val router = routerOf(mapOf(
        "page" to "home" // "home" is the default page.
    ))

    render {
        nav("navbar navbar-expand-lg navbar-light bg-light") {
            div("container-fluid") {
                div() {
                    ul("navbar-nav") {
                        listOf("home", "about", "contact").forEach {page ->
                            li("nav-item") {
                                a("nav-link") {
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
                }
            }
        }

        router.select("page").render {(value, _) ->
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
}
