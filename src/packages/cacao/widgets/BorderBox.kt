package packages.cacao.widgets

import packages.cacao.elements.Element
import packages.cacao.elements.SingleChildRenderObjectElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderText

class BorderBox(override var child: Widget) : SingleChildRenderObjectWidget() {
    override fun createRenderObject(): RenderObject = RenderText(TODO())

    override fun createElement(): SingleChildRenderObjectElement = SingleChildRenderObjectElement(this)
}
