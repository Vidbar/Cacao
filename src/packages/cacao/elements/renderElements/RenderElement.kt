package packages.cacao.elements.renderElements

import packages.cacao.elements.Element
import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.RenderWidget
import packages.cacao.widgets.Widget

abstract class RenderElement(widget: RenderWidget) : Element(widget) {
    var renderObject: RenderObject? = null

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.renderObject = (this.widget as RenderWidget).createRenderObject()
        attachRenderObject()
    }

    abstract fun insertChildRenderObject(child: RenderObject)

    fun attachRenderObject() {
        val ancestorRenderObjectElement = findAncestorRenderObjectElement()
        this.renderObject?.let { ancestorRenderObjectElement?.insertChildRenderObject(it) }
    }

    fun findAncestorRenderObjectElement(): RenderElement? {
        var ancestor = this.parent
        while (ancestor != null && ancestor !is RenderElement)
            ancestor = ancestor.parent
        return ancestor as? RenderElement
    }

    override fun performRebuild() {
        this.renderObject?.let { (this.widget as RenderWidget).updateRenderObject(it) }
    }

    override fun update(newWidget: Widget) {
        super.update(newWidget)
        this.renderObject?.let { (this.widget as RenderWidget).updateRenderObject(it) }
    }
}
