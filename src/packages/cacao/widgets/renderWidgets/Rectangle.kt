package packages.cacao.widgets.renderWidgets

import packages.cacao.elements.renderElements.SingleChildRenderElement
import packages.cacao.renderObjects.RectangleRenderObject
import packages.cacao.renderObjects.RenderObject
import packages.cacao.widgets.ISingleChildWidget
import packages.cacao.widgets.RenderWidget
import packages.cacao.widgets.Widget

public class Rectangle(override var child: Widget) : RenderWidget(), ISingleChildWidget {
    override fun createElement(): SingleChildRenderElement = SingleChildRenderElement(this)

    override fun createRenderObject(): RenderObject = RectangleRenderObject()
}
