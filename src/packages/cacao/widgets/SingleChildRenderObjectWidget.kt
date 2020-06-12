package packages.cacao.widgets

import packages.cacao.elements.Element
import packages.cacao.elements.SingleChildRenderObjectElement

abstract class SingleChildRenderObjectWidget: RenderObjectWidget() {
    abstract var child: Widget
    override fun createElement(): SingleChildRenderObjectElement = SingleChildRenderObjectElement(this)
}