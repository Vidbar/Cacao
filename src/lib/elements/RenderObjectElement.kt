package lib.elements

import lib.renderObjects.RenderObject
import lib.widgets.RenderObjectWidget

abstract class RenderObjectElement(widget: RenderObjectWidget) : Element(widget) {
    override val widget: RenderObjectWidget
        get() = super.widget as RenderObjectWidget

    var renderObject: RenderObject? = null

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.renderObject = widget.createRenderObject()
        attachRenderObject()
    }

    abstract fun insertChildRenderObject(child: RenderObject)

    fun attachRenderObject() {
        val ancestorRenderObjectElement = findAncestorRenderObjectElement()
        this.renderObject?.let { ancestorRenderObjectElement?.insertChildRenderObject(it) }
    }

    fun findAncestorRenderObjectElement(): RenderObjectElement? {
        var ancestor = this.parent
        while (ancestor != null && ancestor !is RenderObjectElement)
            ancestor = ancestor.parent
        return ancestor as? RenderObjectElement
    }
}