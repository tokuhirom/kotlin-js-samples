package org.example

import mui.material.AppBar
import mui.material.AppBarPosition
import mui.material.Button
import mui.material.ButtonColor
import mui.material.CssBaseline
import mui.material.Grid
import mui.material.GridProps
import mui.material.Toolbar
import mui.system.responsive
import react.Fragment
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.p
import web.dom.document
import web.prompts.alert

// https://github.com/karakum-team/kotlin-mui-showcase/blob/5b7263a6a1379e40297f335f9e6be07e161dc9a7/src/jsMain/kotlin/team/karakum/MissedWrappers.kt#L8
inline var GridProps.xs: Int
    get() = TODO("Prop is write-only!")
    set(value) {
        asDynamic().xs = value
    }


fun main() {
    try {
        val container = document.getElementById("root") ?: error("Couldn't find root container!")
        createRoot(container).render(Fragment.create {
            CssBaseline()

            AppBar {
                position = AppBarPosition.static
                Toolbar {
                    listOf("top", "about", "contact").forEach { name ->
                        Button {
                            color = ButtonColor.inherit
                            +name.replaceFirstChar { it.titlecase() }
                        }
                    }
                }
            }

            Grid {
                this.container = true
                spacing = responsive(2)

                Grid {
                    item = true
                    xs = 4

                    h1 {
                        +"This is sidebar..."
                    }
                    p {
                        +"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ultrices dui sapien eget mi. Adipiscing commodo elit at imperdiet dui accumsan sit. Nam libero justo laoreet sit amet cursus sit amet. Sed tempus urna et pharetra pharetra massa. Habitasse platea dictumst vestibulum rhoncus. Bibendum at varius vel pharetra vel turpis nunc eget lorem. Ullamcorper velit sed ullamcorper morbi tincidunt ornare massa eget egestas. Volutpat consequat mauris nunc congue nisi vitae suscipit. Velit ut tortor pretium viverra suspendisse potenti. Non nisi est sit amet facilisis magna. Donec et odio pellentesque diam volutpat. Turpis egestas sed tempus urna et pharetra pharetra massa massa. Id cursus metus aliquam eleifend mi.\n"
                        + "Eget mi proin sed libero enim. Adipiscing elit ut aliquam purus sit amet luctus. Placerat vestibulum lectus mauris ultrices eros. Semper quis lectus nulla at volutpat diam ut venenatis tellus. Lacus sed viverra tellus in hac. Est sit amet facilisis magna etiam tempor orci eu. Lectus sit amet est placerat in egestas erat. Diam sit amet nisl suscipit adipiscing bibendum. In vitae turpis massa sed. Urna molestie at elementum eu facilisis sed odio morbi. Dapibus ultrices in iaculis nunc sed. Nisl vel pretium lectus quam id leo in. Ac orci phasellus egestas tellus rutrum tellus pellentesque eu. Tincidunt tortor aliquam nulla facilisi. Erat velit scelerisque in dictum non consectetur a erat. Aliquam ultrices sagittis orci a scelerisque purus. Arcu odio ut sem nulla pharetra diam sit amet nisl. Iaculis urna id volutpat lacus laoreet non. Egestas quis ipsum suspendisse ultrices gravida dictum fusce."
                        + "Vel orci porta non pulvinar neque. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit. Ipsum nunc aliquet bibendum enim facilisis. At imperdiet dui accumsan sit amet nulla facilisi morbi tempus. Sed ullamcorper morbi tincidunt ornare massa eget egestas purus. Quam adipiscing vitae proin sagittis. Odio facilisis mauris sit amet massa vitae tortor condimentum. Consectetur purus ut faucibus pulvinar elementum integer enim neque volutpat. Leo duis ut diam quam nulla porttitor massa. Neque aliquam vestibulum morbi blandit cursus. Cursus mattis molestie a iaculis at erat pellentesque adipiscing. Sit amet nulla facilisi morbi. Tristique nulla aliquet enim tortor at auctor urna. In hendrerit gravida rutrum quisque non tellus orci. Augue interdum velit euismod in. Morbi tristique senectus et netus et malesuada fames ac."
                        + "Erat nam at lectus urna duis convallis convallis. Tristique magna sit amet purus gravida quis. Vitae nunc sed velit dignissim sodales ut eu sem. Donec et odio pellentesque diam volutpat commodo sed egestas. Sit amet nisl suscipit adipiscing bibendum est ultricies integer. Scelerisque viverra mauris in aliquam sem fringilla ut morbi. Sagittis purus sit amet volutpat consequat mauris nunc congue nisi. Facilisis leo vel fringilla est ullamcorper eget nulla facilisi. Ut sem viverra aliquet eget sit amet tellus. Lobortis feugiat vivamus at augue eget arcu. Dictum non consectetur a erat nam at lectus urna duis. Nisi vitae suscipit tellus mauris. Lectus mauris ultrices eros in cursus turpis massa tincidunt dui. Et netus et malesuada fames. Leo a diam sollicitudin tempor id eu nisl nunc mi."
                        + "Magna fringilla urna porttitor rhoncus dolor purus non enim. Lectus vestibulum mattis ullamcorper velit sed ullamcorper. Urna neque viverra justo nec. Tristique senectus et netus et malesuada fames ac turpis. Non odio euismod lacinia at. Turpis massa tincidunt dui ut ornare. Urna id volutpat lacus laoreet non curabitur. Ut porttitor leo a diam sollicitudin tempor id. Enim neque volutpat ac tincidunt. Condimentum vitae sapien pellentesque habitant morbi tristique senectus et."
                    }
                }
                Grid {
                    xs = 8

                    h1 {
                        +"Hello, world!"
                    }
                }
            }
        })
    } catch (e: Exception) {
        println(e.message ?: "An error occurred")
        alert(e.message ?: "An error occurred")
    }
}
