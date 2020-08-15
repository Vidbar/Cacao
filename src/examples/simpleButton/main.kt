package examples.simpleButton

import packages.cacao.run
import packages.cacao.widgets.StatefulWidget
import packages.cacao.widgets.Text
import packages.cacao.widgets.Widget
import packages.cacao.widgets.button

fun main() {
    run(
        ChangeTextButton()
    )
}

class ChangeTextButton : StatefulWidget() {
    private var text = "hello!"
    private fun changeText() {
        setState { this.text = "hola!" }
    }

    override fun build(): Widget {
        return button(Text(this.text)) {
            onClick = { changeText() }
        }
    }
}