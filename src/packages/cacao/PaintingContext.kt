package packages.cacao

import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphicsAdapter.JwtAdapter
import packages.cacao.renderObjects.RenderObject

class PaintingContext(private val paintBounds: Rectangle) {
    val canvas: Canvas

    init {
        val width = this.paintBounds.left + this.paintBounds.right
        val height = this.paintBounds.top + this.paintBounds.bottom
        val drawingSurface = Size(width, height)
        val jwtAdapter = JwtAdapter(drawingSurface)
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