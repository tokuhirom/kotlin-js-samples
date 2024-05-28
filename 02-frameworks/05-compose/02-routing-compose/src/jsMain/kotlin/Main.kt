package org.example

import androidx.compose.runtime.Composable
import app.softwork.routingcompose.HashRouter
import app.softwork.routingcompose.NavLink
import app.softwork.routingcompose.Parameters
import app.softwork.routingcompose.Router
import app.softwork.routingcompose.navigate
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.backgroundColor
import org.jetbrains.compose.web.css.display
import org.jetbrains.compose.web.css.justifyContent
import org.jetbrains.compose.web.css.padding
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.Li
import org.jetbrains.compose.web.dom.Nav
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.dom.Ul
import org.jetbrains.compose.web.renderComposable

@Composable
fun navBar() {
    Nav(attrs = {
        style {
            display(DisplayStyle.Flex)
            justifyContent(JustifyContent.SpaceAround)
            padding(16.px)
            backgroundColor(Color.lightblue)
        }
    }) {
        NavLink(to = "/") {
            Text("Top")
        }
        NavLink(to = "/hello") {
            Text("Hello")
        }
        NavLink(to = "/greet") {
            Text("Greet")
        }
        NavLink(to = "/user") {
            Text("User")
        }
        NavLink(to = "/about") {
            Text("About")
        }
    }
}

val users = listOf("paul", "john", "ringo", "george")

fun main() {
    renderComposable(rootElementId = "root") {
        HashRouter(initPath = "/") {
            route("/hello") {
                navBar()

                Text("Hello World")
                val router = Router.current

                Input(type = InputType.Button) {
                    onClick {
                        router.navigate("/greet", Parameters.from("name" to "paul"))
                    }
                    value("Navigate to greet with the userName paul")
                }
                NavLink(to = "/greet?name=paul") {
                    Text("Paul")
                }
            }
            route("/about") {
                navBar()
                Text("About me")
            }
            route("/") {
                navBar()
                Text("Top page")
            }
            route("/user") {
                navBar()

                int {id ->
                    val user = users[id]
                    if (user!= null) {
                        Text("User: $user")
                    } else {
                        Text("User not found")
                        NavLink(to = "/user") {
                            Text("Back")
                        }
                    }
                }
                noMatch {
                    Ul {
                        users.forEachIndexed { index, s ->
                            Li {
                                NavLink(to = "/user/$index") {
                                    Text(s)
                                }
                            }
                        }
                    }
                }
            }
            route("/greet") {
                navBar()

                parameters?.map?.get("name")?.let { name ->
                    Text("Hello, ${name[0]}!")
                } ?: run {
                    Text("Hello, World!")
                }
            }
            noMatch {
                Text("Not found!")
            }
        }
    }
}
