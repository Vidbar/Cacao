package lib.elements

import lib.widgets.Widget

abstract class ComponentElement(widget: Widget) : Element(widget) {
    var child: Element? = null
    protected abstract fun build(): Widget
}