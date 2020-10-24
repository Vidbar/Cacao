package packages.cacao.elements.renderElements

import packages.cacao.elements.Element
import packages.cacao.elements.ElementVisitor
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.SingleChildRenderObject
import packages.cacao.widgets.ISingleChildWidget
import packages.cacao.widgets.RenderWidget
import packages.cacao.widgets.Widget

public open class SingleChildRenderElement(widget: RenderWidget) : RenderElement(widget) {
    public var child: Element? = null

    override fun insertChildRenderObject(child: RenderObject) {
        val renderObject = this.renderObject as SingleChildRenderObject
        renderObject.child = child
    }

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }

    public override fun mount(parent: Element?) {
        super.mount(parent)
        if (this.widget is ISingleChildWidget) {
            this.child = updateChild(this.child, (this.widget as ISingleChildWidget).child)
        }
    }

    override fun update(newWidget: Widget) {
        super.update(newWidget)
        if (this.widget is ISingleChildWidget) {
            this.child = this.updateChild(this.child, (this.widget as ISingleChildWidget).child)
        }
    }
}
