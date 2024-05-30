import js.promise.Promise
import kotlinx.browser.window
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML

external interface Versions {
    fun node(): String
    fun chrome(): String
    fun electron(): String
    fun ping(): Promise<String>
}

fun main() {
    try {
        val hoge = Hoge("hoge", 33)

        val versions = window.asDynamic().versions as Versions

        println("Node version: ${versions.node()}")
        println("Chrome version: ${versions.chrome()}")
        println("Electron version: ${versions.electron()}")

        versions.ping().then {
            println("Ping response(): $it")
        }

        val container = web.dom.document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container).render(Fragment.create {
            ReactHTML.h1 {
                +"Hello, Electron+React+Kotlin/JS!"
            }
        })
        println("Hello, electron World! $hoge!! mjs!! ん")
    } catch (e: Throwable) {
        console.error(e)
    }
}
