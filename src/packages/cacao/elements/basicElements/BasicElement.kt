package packages.cacao.elements.basicElements

import packages.cacao.elements.Element
import packages.cacao.elements.ElementVisitor
import packages.cacao.widgets.BasicWidget
import packages.cacao.widgets.Widget

abstract class BasicElement(widget: BasicWidget) : Element(widget) {

    fun build() = (this.widget as BasicWidget).build()

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.rebuild()

        (this.widget as BasicWidget).mounted()
    }

    override fun update(newWidget: Widget) {
        super.update(newWidget)
        rebuild()
    }

    override fun visitChildren(visitor: ElementVisitor) {
        TODO("Not yet implemented")
    }
}
