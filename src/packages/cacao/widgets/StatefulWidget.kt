package packages.cacao.widgets

import packages.cacao.Updater
import packages.cacao.elements.ComponentElement
import packages.cacao.elements.Element
import packages.cacao.elements.ElementVisitor

typealias VoidCallback = () -> Unit

abstract class StatefulWidget : Widget() {
    var element: StatefulElement? = null
    fun setState(function: VoidCallback) {
        function()

        this.element!!.markNeedsBuild()

        Updater.updater.enqueueUpdate()
        Updater.updater.resolveUpdates()
    }

    override fun createElement(): StatefulElement = StatefulElement(this)
    abstract fun build(): Widget
    open fun mounted() {
    }
}

class StatefulElement(widget: StatefulWidget) : ComponentElement(widget) {
    override val widget: StatefulWidget
        get() = super.widget as StatefulWidget

    init {
        widget.element = this
    }

    override fun build(): Widget = this.widget.build()

    override fun visitChildren(visitor: ElementVisitor) {
        TODO("Not yet implemented")
    }

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.widget.mounted()
    }
}
