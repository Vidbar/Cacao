package packages.cacao.widgets

import packages.cacao.elements.SingleChildRenderElement

abstract class SingleChildRenderWidget : RenderWidget() {
    abstract var child: Widget
    override fun createElement(): SingleChildRenderElement = SingleChildRenderElement(this)
}
