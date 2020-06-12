package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.RenderObjectWidget

class LeafRenderObjectElement(widget: RenderObjectWidget): RenderObjectElement(widget) {
    override fun insertChildRenderObject(child: RenderObject) {
    }

    override fun visitChildren(visitor: ElementVisitor) {
    }
}