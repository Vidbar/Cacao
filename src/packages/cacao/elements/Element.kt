package packages.cacao.elements

import packages.cacao.widgets.Widget

abstract class Element(open val widget: Widget) {
    var parent: Element? = null

    open fun mount(parent: Element?) {
        this.parent = parent
    }

    protected fun updateChild(child: Element?, newWidget: Widget): Element {
        val newChild = if (child != null)
            TODO()
        else
            inflateWidget(newWidget)
        return newChild
    }

    protected fun inflateWidget(newWidget: Widget): Element {
        val newChild = newWidget.createElement()
        newChild.mount(this)
        return newChild
    }

    abstract fun visitChildren(visitor: ElementVisitor)
}

typealias ElementVisitor = (Element) -> Boolean