package org.example

import kotlinx.browser.document

@JsModule("bootstrap/dist/css/bootstrap.min.css")
@JsNonModule
external val bootstrapCss: dynamic

fun main() {
    bootstrapCss

    val div = document.createElement("div")
    div.className = "alert alert-primary"
    div.textContent = "Hello Kotlin World!"

    document.getElementById("root")?.appendChild(div)
}
