package packages.cacao.widgets.renderWidgets

import packages.cacao.elements.renderElements.SingleChildRenderElement
import packages.cacao.geometry.Size
import packages.cacao.renderObjects.ViewRenderObject
import packages.cacao.widgets.ISingleChildWidget
import packages.cacao.widgets.RenderWidget
import packages.cacao.widgets.Widget

class View(val size: Size, override val child: Widget) : RenderWidget(), ISingleChildWidget {
    override fun createElement(): SingleChildRenderElement = SingleChildRenderElement(this)

    private var viewRenderObject: ViewRenderObject? = null
    override fun createRenderObject(): ViewRenderObject {
        if (this.viewRenderObject == null) {
            this.viewRenderObject = ViewRenderObject(size)
        }

        return this.viewRenderObject!!
    }
}
