package lib.widgets

import lib.elements.Element
import lib.elements.SingleChildRenderObjectElement
import lib.renderObjects.RenderObject
import lib.renderObjects.RenderText

class RichText(private val text: String) : RenderObjectWidget() {
    override fun createRenderObject(): RenderObject = RenderText(text)

    override fun createElement(): Element = SingleChildRenderObjectElement(this)
}
