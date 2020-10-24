package packages.cacao.elements

import packages.cacao.BuildOwner
import packages.cacao.widgets.Widget

public abstract class Element(public open var widget: Widget) {
    public var parent: Element? = null
    private var owner: BuildOwner? = null

    protected open fun mount(parent: Element?) {
        this.parent = parent
        if (parent != null) {
            this.owner = parent.owner
        }
    }

    protected fun updateChild(child: Element?, newWidget: Widget): Element {
        return if (child != null) {
            child.update(newWidget)
            child
        } else
            this.createAndMountElement(newWidget)
    }

    protected open fun update(newWidget: Widget) {
        this.widget = newWidget
    }

    private fun createAndMountElement(newWidget: Widget): Element {
        val newChild = newWidget.createElement()
        newChild.mount(this)
        return newChild
    }

    public abstract fun visitChildren(visitor: ElementVisitor)

    public fun assignOwner(owner: BuildOwner) {
        this.owner = owner
    }

    public fun markNeedsBuild() {
        this.owner?.scheduleBuildFor(this)
    }

    public fun rebuild() {
        this.performRebuild()
    }

    protected abstract fun performRebuild()
}

public typealias ElementVisitor = (Element) -> Boolean
