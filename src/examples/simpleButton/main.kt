package examples.simpleButton

import packages.cacao.run
import packages.cacao.widgets.StatefulWidget
import packages.cacao.widgets.Widget
import packages.cacao.widgets.basicWidgets.Button

fun main() {
    run(
        ChangeTextButton()
    )
}

class ChangeTextButton : StatefulWidget() {
    private val spanishGreeting = "hola!"
    private val englishGreeting = "hello!"

    private var text = this.englishGreeting
    private fun toggleText() {
        setState { this.text = if (this.text == this.englishGreeting) this.spanishGreeting else this.englishGreeting }
    }

    override fun build(): Widget {
        return Button(this.text).apply {
            onClick = { toggleText() }
        }
    }
}
