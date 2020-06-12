package packages.cacao.elements

import packages.cacao.widgets.Widget

abstract class ComponentElement(widget: Widget) : Element(widget) {
    var child: Element? = null
    protected abstract fun build(): Widget
}