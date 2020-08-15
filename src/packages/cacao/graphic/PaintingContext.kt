package packages.cacao.graphic

import packages.cacao.Canvas
import packages.cacao.geometry.Rectangle
import packages.cacao.renderObjects.RenderObject

lateinit var adapter: IGraphicAdapter

fun setGraphicAdapter(newAdapter: IGraphicAdapter) {
    adapter = newAdapter
}

class PaintingContext(private val paintBounds: Rectangle) {
    val canvas: Canvas = Canvas(adapter)

    fun paintChild(child: RenderObject) {
        child.paint(this)
    }
}

fun paintRenderObject(renderObject: RenderObject) {
    val rectangle = Rectangle(0.0, 0.0, renderObject.size.width, renderObject.size.height)
    val context = PaintingContext(rectangle)
    renderObject.paint(context)
}