package packages.cacao.renderObjects

import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext

public class RectangleRenderObject : SingleChildRenderObject() {
    override lateinit var size: Size

    override fun paint(context: PaintingContext) {
        this.child?.run {
            val rectangle = Rectangle(0.0, 0.0, this.size.width, this.size.height)
            context.canvas.drawRectangle(rectangle)
            context.paintChild(this)
        }
    }

    override fun performLayout() {
        this.child?.let {
            it.layout(Size.zero)
            this.size = it.size
        }
    }
}
