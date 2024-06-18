package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.browser.document
import kotlinx.dom.clear
import kotlinx.serialization.Serializable

@Serializable
data class ResponseEntity(
    val name: String,
)

suspend fun main() {
    val client =
        HttpClient(Js) {
            install(ContentNegotiation) {
                json()
            }
            install(Logging) {
                level = LogLevel.INFO
            }
        }

    val res = client.get("./data.json")
    println(res.status.value)
    println("content-type: ${res.contentType()}")

    try {
        val data: ResponseEntity = res.body()
        println(data)

        val div = document.createElement("div")
        div.className = "alert alert-primary"
        div.textContent = "Hello ${data.name}"

        val root = document.getElementById("root")
        root?.clear()
        root?.appendChild(div)
    } catch (e: Exception) {
        println(e)
    }
}
