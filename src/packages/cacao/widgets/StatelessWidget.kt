package packages.cacao.widgets

import packages.cacao.elements.ComponentElement
import packages.cacao.elements.Element
import packages.cacao.elements.ElementVisitor

abstract class StatelessWidget : Widget() {
    override fun createElement(): Element = StatelessElement(this)
    abstract fun build(): Widget
}

class StatelessElement(widget: StatelessWidget) : ComponentElement(widget) {
    override val widget: StatelessWidget
        get() = super.widget as StatelessWidget

    override fun build() = widget.build()

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }
}
