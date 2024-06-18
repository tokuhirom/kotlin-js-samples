package org.example

import emotion.react.css
import js.errors.JsError
import react.Component
import react.FC
import react.Fragment
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.router.RouteObject
import react.router.RouterProvider
import react.router.dom.NavLink
import react.router.dom.createHashRouter
import react.router.useRouteError
import web.cssom.Display
import web.cssom.JustifyContent
import web.cssom.NamedColor
import web.cssom.None
import web.cssom.path
import web.cssom.px
import web.dom.document
import web.prompts.alert

val NavBar =
    FC {
        div {
            css {
                display = Display.flex
                justifyContent = JustifyContent.spaceBetween
                padding = 16.px
                backgroundColor = NamedColor.lightblue
            }
            NavLink {
                css {
                    margin = 8.px
                    padding = 8.px
                    color = NamedColor.white
                    textDecoration = None.none
                    hover {
                        backgroundColor = NamedColor.darkblue
                    }
                }
                to = "/"
                +"Root"
            }
            listOf("about", "fail").forEach { title ->
                NavLink {
                    css {
                        margin = 8.px
                        padding = 8.px
                        color = NamedColor.white
                        textDecoration = None.none
                        hover {
                            backgroundColor = NamedColor.darkblue
                        }
                    }
                    to = "/$title"
                    +title.replaceFirstChar { it.titlecase() }
                }
            }
        }
    }

val RootContent =
    FC {
        NavBar()
        div {
            +"Root"
        }
    }
val AboutContent =
    FC {
        NavBar()
        div {
            +"About page"
        }
    }
val FailContent =
    FC {
        NavBar()
        // エラーが発生するようにしてみる
        throw Error("Failed to render")
    }

val ErrorPage =
    FC<Props> {
        val error = useRouteError().unsafeCast<JsError>()

        div {
            css {
                color = NamedColor.red
            }
            +error.message
        }
    }

fun main() {
    try {
        val container = document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container).render(
            Fragment.create {
                RouterProvider {
                    router =
                        createHashRouter(
                            arrayOf(
                                RouteObject(
                                    path = "/",
                                    Component = RootContent,
                                ),
                                RouteObject(
                                    path = "/about",
                                    Component = AboutContent,
                                ),
                                RouteObject(
                                    path = "/fail",
                                    Component = FailContent,
                                    ErrorBoundary = ErrorPage,
                                ),
                            ),
                        )
                }
            },
        )
    } catch (e: Exception) {
        println(e.message ?: "An error occurred")
        alert(e.message ?: "An error occurred")
    }
}
