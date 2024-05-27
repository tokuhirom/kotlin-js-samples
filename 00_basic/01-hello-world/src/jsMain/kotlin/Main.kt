package org.example

import kotlinx.browser.document

fun main() {
    console.log("Hello Console World!")

    document.getElementById("root")?.textContent = "Hello Kotlin World!"
}
