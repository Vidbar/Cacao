package examples.counter

import packages.cacao.widgets.StatefulWidget
import packages.cacao.widgets.Text
import packages.cacao.widgets.Widget
import kotlin.concurrent.timer

fun main() {
    packages.cacao.run(Counter())
}

class Counter : StatefulWidget() {
    private var counter: Int = 0
    override fun build(): Widget {
        return Text("Counter: $counter")
    }

    override fun mounted() {
        timer(period = 1000) {
            setState {
                counter++
            }
        }
    }
}
