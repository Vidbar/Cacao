package packages.cacao.widgets

import packages.cacao.elements.RootElement
import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderView

class RootWidget(private val renderView: RenderView, val child: Widget) : RenderWidget() {
    override fun createElement(): RootElement = RootElement(this)

    override fun createRenderObject(): RenderObject = this.renderView
}
