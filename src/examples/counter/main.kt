package examples.counter

import packages.cacao.run
import packages.cacao.widgets.StatefulWidget
import packages.cacao.widgets.Widget
import packages.cacao.widgets.basicWidgets.Text
import kotlin.concurrent.timer

public fun main() {
    run(Counter())
}

public class Counter : StatefulWidget() {
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
