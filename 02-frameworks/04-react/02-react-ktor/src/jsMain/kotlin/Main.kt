package org.example

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.fetch.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.await
import kotlinx.serialization.Serializable
import org.w3c.fetch.Response
import react.FC
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.useEffect
import react.useState
import web.cssom.PropertyName.Companion.container
import web.dom.document
import web.prompts.alert
import kotlin.js.Promise

@Serializable
data class ResponseEntity(val name: String)

val client = HttpClient() {
    install(ContentNegotiation) {
        json()
    }
}

val MyContent = FC {
    val (name, setName) = useState<String?>(null)

    useEffect {
        val res = client.get("./data.json")
        val data = res.body<ResponseEntity>()
        setName(data.name)
    }

    h1 {
        if (name != null) {
            +"Hello $name"
        } else {
            +"Loading..."
        }
    }
}


fun main() {
    try {
        val container = document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container).render(Fragment.create {
            MyContent()
        })
    } catch (e: Exception) {
        println(e.message ?: "An error occurred")
        alert(e.message ?: "An error occurred")
    }
}
