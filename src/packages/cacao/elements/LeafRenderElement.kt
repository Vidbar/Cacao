package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.RenderWidget

class LeafRenderElement(widget: RenderWidget) : RenderElement(widget) {
    override fun insertChildRenderObject(child: RenderObject) {
    }

    override fun visitChildren(visitor: ElementVisitor) {
    }
}
