package packages.cacao.widgets

import packages.cacao.Updater
import packages.cacao.elements.basicElements.SingleChildBasicElement

typealias VoidCallback = () -> Unit

abstract class StatefulWidget : BasicWidget() {
    var element: StatefulElement? = null
    fun setState(function: VoidCallback) {
        function()

        this.element!!.markNeedsBuild()

        Updater.updater.enqueueUpdate()
        Updater.updater.resolveUpdates()
    }

    override fun createElement(): StatefulElement = StatefulElement(this)
}

class StatefulElement(widget: StatefulWidget) : SingleChildBasicElement(widget) {
    init {
        widget.element = this
    }
}
