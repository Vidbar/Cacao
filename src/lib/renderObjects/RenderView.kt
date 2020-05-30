package lib.renderObjects

import lib.PaintingContext
import lib.geometry.Offset
import lib.geometry.Rectangle
import lib.geometry.Size

class RenderView(val width: Double, val height: Double) : RenderObjectWithChild() {
    val size: Size = Size(width, height)

    override val paintBounds: Rectangle
        get() = Offset.zero + this.size

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }
}