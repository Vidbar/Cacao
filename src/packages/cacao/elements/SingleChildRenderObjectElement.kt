package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderObjectWithChild
import packages.cacao.widgets.RenderObjectWidget
import packages.cacao.widgets.SingleChildRenderObjectWidget

class SingleChildRenderObjectElement(override val widget: SingleChildRenderObjectWidget) : RenderObjectElement(widget) {
    var child: Element? = null

    override fun insertChildRenderObject(child: RenderObject) {
        val renderObject = this.renderObject as RenderObjectWithChild
        renderObject.child = child
    }

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.child = updateChild(this.child, this.widget.child)
    }
}