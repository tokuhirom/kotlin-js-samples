package org.example

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import org.jetbrains.compose.web.renderComposable

fun main() {
    var count: Int by mutableStateOf(0)

    renderComposable(rootElementId = "root") {
        Div {
            Text("$count")
        }
        Div {
            Button(attrs = {
                onClick { count -= 1 }
            }) {
                Text("Decrement")
            }

            Button(attrs = {
                onClick { count += 1 }
            }) {
                Text("Increment")
            }
        }
    }
}
