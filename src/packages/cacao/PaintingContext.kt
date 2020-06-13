package packages.cacao

import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphicsAdapter.JwtAdapter
import packages.cacao.renderObjects.RenderObject

private var graphicAdapter: (Size) -> IGraphicAdapter = { size: Size -> JwtAdapter(size) }

class PaintingContext(private val paintBounds: Rectangle) {
    val canvas: Canvas

    init {
        val width = this.paintBounds.left + this.paintBounds.right
        val height = this.paintBounds.top + this.paintBounds.bottom
        val drawingSurface = Size(width, height)
        val jwtAdapter = graphicAdapter(drawingSurface)
        this.canvas = Canvas(jwtAdapter)
    }

    fun paintChild(child: RenderObject) {
        child.paint(this)
    }
}

fun repaintCompositeChild(child: RenderObject) {
    val context = PaintingContext(child.paintBounds)
    child.paint(context)
}

fun changeGraphicAdapter(newGraphicAdapter: (Size) -> IGraphicAdapter) {
    graphicAdapter = newGraphicAdapter
}