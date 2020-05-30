package lib.widgets

import lib.elements.RootElement
import lib.renderObjects.RenderObject
import lib.renderObjects.RenderView

class RootWidget(private val renderView: RenderView, val child: Widget) : RenderObjectWidget() {
    public override fun createElement(): RootElement = RootElement(this)

    override fun createRenderObject(): RenderObject = this.renderView
}