package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.SingleChildRenderObject
import packages.cacao.widgets.SingleChildRenderWidget
import packages.cacao.widgets.Widget

class SingleChildRenderElement(widget: SingleChildRenderWidget) : RenderElement(widget) {
    override val widget: SingleChildRenderWidget
        get() = super.widget as SingleChildRenderWidget

    var child: Element? = null

    override fun insertChildRenderObject(child: RenderObject) {
        val renderObject = this.renderObject as SingleChildRenderObject
        renderObject.child = child
    }

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.child = updateChild(this.child, this.widget.child)
    }

    override fun update(newWidget: Widget) {
        super.update(newWidget)
        this.child = this.updateChild(this.child, widget.child)
    }
}
