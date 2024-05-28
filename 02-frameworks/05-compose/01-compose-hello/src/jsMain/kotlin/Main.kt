package org.example

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.jetbrains.compose.web.attributes.*
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
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