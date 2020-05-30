package lib.widgets

import lib.elements.Element
import lib.elements.SingleChildRenderObjectElement
import lib.renderObjects.RenderObject
import lib.renderObjects.RenderText

class BorderBox(child: RenderObjectWidget) : RenderObjectWidget() {
    override fun createRenderObject(): RenderObject = RenderText(TODO())

    override fun createElement(): Element = SingleChildRenderObjectElement(this)
}
