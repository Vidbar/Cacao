package packages.cacao.widgets

import packages.cacao.elements.Element
import packages.cacao.elements.LeafRenderObjectElement
import packages.cacao.elements.RenderObjectElement
import packages.cacao.elements.SingleChildRenderObjectElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderText

class RichText(private val text: String) : RenderObjectWidget() {

    override fun createRenderObject(): RenderObject = RenderText(text)

    override fun createElement(): LeafRenderObjectElement = LeafRenderObjectElement(this)
}
