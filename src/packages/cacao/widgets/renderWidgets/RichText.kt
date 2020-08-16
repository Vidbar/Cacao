package packages.cacao.widgets.renderWidgets

import packages.cacao.elements.LeafRenderElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderText
import packages.cacao.widgets.RenderWidget

class RichText(private val text: String) : RenderWidget() {

    override fun createRenderObject(): RenderObject = RenderText(text)

    override fun createElement(): LeafRenderElement = LeafRenderElement(this)

    override fun updateRenderObject(renderObject: RenderObject) {
        if (renderObject is RenderText) {
            renderObject.text = this.text
        }
    }
}
