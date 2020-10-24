package packages.cacao.graphic

import packages.cacao.Canvas
import packages.cacao.geometry.Rectangle
import packages.cacao.renderObjects.RenderObject

public lateinit var adapter: IGraphicAdapter

public fun setGraphicAdapter(newAdapter: IGraphicAdapter) {
    adapter = newAdapter
}

public class PaintingContext(private val paintBounds: Rectangle) {
    public val canvas: Canvas = Canvas(adapter)

    public fun paintChild(child: RenderObject) {
        child.paint(this)
    }
}

public fun paintRenderObject(renderObject: RenderObject) {
    val rectangle = Rectangle(0.0, 0.0, renderObject.size.width, renderObject.size.height)
    val context = PaintingContext(rectangle)
    renderObject.paint(context)
}
