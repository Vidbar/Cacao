package packages.cacao.widgets

import packages.cacao.elements.Element
import packages.cacao.elements.basicElements.SingleChildBasicElement

abstract class BasicWidget : Widget() {
    override fun createElement(): Element = SingleChildBasicElement(this)
    abstract fun build(): Widget

    open fun mounted() {}
}

/*class StatelessElement(widget: BasicWidget) : ComponentElement(widget) {
    override val widget: BasicWidget
        get() = super.widget as BasicWidget

    override fun build() = widget.build()

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }
}*/
