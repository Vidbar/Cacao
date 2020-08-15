package packages.cacao.widgets.renderWidgets

import packages.cacao.renderObjects.ClickEventListener
import packages.cacao.renderObjects.RenderMouseListener
import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.SingleChildRenderWidget
import packages.cacao.widgets.Widget

class MouseListenerRenderWidget(val onClick: ClickEventListener?, override var child: Widget) :
    SingleChildRenderWidget() {
    override fun createRenderObject(): RenderObject {
        return RenderMouseListener(this.onClick)
    }
}