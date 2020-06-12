package packages.cacao.renderObjects

import packages.cacao.PaintingContext
import packages.cacao.geometry.Offset
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

class RenderView(val width: Double, val height: Double) : RenderObjectWithChild() {
    val size: Size = Size(width, height)

    override val paintBounds: Rectangle
        get() = Offset.zero + this.size

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }
}