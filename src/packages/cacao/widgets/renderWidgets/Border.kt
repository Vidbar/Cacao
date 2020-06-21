package packages.cacao.widgets.renderWidgets

import packages.cacao.renderObjects.RenderBorder
import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.RenderWidget
import packages.cacao.widgets.SingleChildRenderWidget
import packages.cacao.widgets.Widget

class Border(override var child: Widget): SingleChildRenderWidget() {
    override fun createRenderObject(): RenderObject = RenderBorder()
}