package packages.cacao.elements.renderElements

import packages.cacao.elements.ElementVisitor
import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.RenderWidget

open class LeafRenderElement(widget: RenderWidget) : RenderElement(widget) {
    override fun insertChildRenderObject(child: RenderObject) {
    }

    override fun visitChildren(visitor: ElementVisitor) {
    }
}
