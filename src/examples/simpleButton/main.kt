package examples.simpleButton

import packages.cacao.run
import packages.cacao.widgets.Text
import packages.cacao.widgets.button

fun main() {
    run(
            button(Text("hello!")) {
                onClick = {
                    child = Text("hola!")
                }
            }
    )
}