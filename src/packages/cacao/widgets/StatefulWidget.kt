package packages.cacao.widgets

import packages.cacao.Updater
import packages.cacao.elements.basicElements.SingleChildBasicElement

public typealias VoidCallback = () -> Unit

public abstract class StatefulWidget : BasicWidget() {
    public var element: StatefulElement? = null
    public fun setState(function: VoidCallback) {
        function()

        this.element!!.markNeedsBuild()

        Updater.updater.enqueueUpdate()
        Updater.updater.resolveUpdates()
    }

    override fun createElement(): StatefulElement = StatefulElement(this)
}

public class StatefulElement(widget: StatefulWidget) : SingleChildBasicElement(widget) {
    init {
        widget.element = this
    }
}
