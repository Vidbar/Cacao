package packages.cacao.widgets.renderWidgets

import packages.cacao.elements.renderElements.LeafRenderElement
import packages.cacao.elements.renderElements.RenderElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RichTextRenderObject
import packages.cacao.widgets.RenderWidget

public class RichText(private val text: String) : RenderWidget() {
    override fun createElement(): RenderElement = LeafRenderElement(this)

    override fun createRenderObject(): RenderObject = RichTextRenderObject(text)

    override fun updateRenderObject(renderObject: RenderObject) {
        if (renderObject is RichTextRenderObject) {
            renderObject.text = this.text
        }
    }
}
