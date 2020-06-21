package packages.cacao.widgets

import packages.cacao.elements.LeafRenderElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderText

class RichText(private val text: String) : RenderWidget() {

    override fun createRenderObject(): RenderObject = RenderText(text)

    override fun createElement(): LeafRenderElement = LeafRenderElement(this)
}
