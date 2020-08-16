package packages.cacao.elements

import packages.cacao.widgets.Widget

abstract class ComponentElement(widget: Widget) : Element(widget) {
    var child: Element? = null
    protected abstract fun build(): Widget

    override fun performRebuild() {
        val built = this.build()
        this.child = updateChild(this.child, built)
    }

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.rebuild()
    }

    override fun update(newWidget: Widget) {
        super.update(newWidget)
        rebuild()
    }
}