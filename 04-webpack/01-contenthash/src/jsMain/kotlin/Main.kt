package org.example

import kotlinx.browser.document

fun main() {
    console.log("Loaded!")
    val container = document.getElementById("root") ?: error("Couldn't find root container!")
    container.textContent = "Hello, Kotlin/JS!"
}
