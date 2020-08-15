package packages.cacao.elements

import packages.cacao.BuildOwner
import packages.cacao.widgets.Widget

abstract class Element(open val widget: Widget) {
    var parent: Element? = null
    private var owner: BuildOwner? = null

    open fun mount(parent: Element?) {
        this.parent = parent
        if (parent != null) {
            this.owner = parent.owner
        }
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

    fun assignOwner(owner: BuildOwner) {
        this.owner = owner
    }

    fun markNeedsBuild() {
        this.owner?.scheduleBuildFor(this)
    }

    fun rebuild() {
        this.performRebuild()
    }

    protected abstract fun performRebuild()
}

typealias ElementVisitor = (Element) -> Boolean