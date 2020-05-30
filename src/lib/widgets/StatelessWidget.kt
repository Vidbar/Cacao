package lib.widgets

import lib.elements.ComponentElement
import lib.elements.Element

abstract class StatelessWidget : Widget() {
    override fun createElement(): Element = StatelessElement(this)
    abstract fun build(): Widget
}

class StatelessElement(widget: StatelessWidget) : ComponentElement(widget) {
    override val widget: StatelessWidget
        get() = super.widget as StatelessWidget

    override fun build() = widget.build()

    override fun mount(parent: Element?) {
        super.mount(parent)
        val built = this.build()
        this.child = this.updateChild(this.child, built)
    }
}
