package lib.renderObjects

import lib.PaintingContext
import lib.geometry.Rectangle

abstract class RenderObject {
    abstract val paintBounds: Rectangle

    abstract fun paint(context: PaintingContext)
}