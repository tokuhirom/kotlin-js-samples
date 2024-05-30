import js.promise.Promise
import kotlinx.browser.document
import kotlinx.browser.window
import web.timers.setInterval
import kotlin.time.Duration.Companion.seconds

external interface Versions {
    fun node(): String
    fun chrome(): String
    fun electron(): String
    fun ping(): Promise<String>
}

suspend fun main() {
    try {
        val hoge = Hoge("hoge", 33)

        val versions = window.asDynamic().versions as Versions

        println("Node version: ${versions.node()}")
        println("Chrome version: ${versions.chrome()}")
        println("Electron version: ${versions.electron()}")

        versions.ping().then {
            println("Ping response(): $it")
        }

        document.getElementById("root")?.let {root ->
            setInterval(1.seconds) {
                println("invoked timer...")
                val div = document.createElement("div")
                div.textContent = "Hello, World! WOWYAY!! ASAGE $hoge"
                root.appendChild(div)
            }
        }
        println("Hello, electron World! $hoge!! mjs!! ん")
    } catch (e: Throwable) {
        console.error(e)
    }
}
