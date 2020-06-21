package packages.cacao.widgets

import packages.cacao.elements.SingleChildRenderElement
import packages.cacao.renderObjects.RenderBorder
import packages.cacao.renderObjects.RenderObject

class Border(override var child: Widget) : SingleChildRenderWidget() {
    override fun createRenderObject(): RenderObject = RenderBorder()

    override fun createElement(): SingleChildRenderElement = SingleChildRenderElement(this)
}
