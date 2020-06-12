package packages.cacao.renderObjects

import packages.cacao.PaintingContext
import packages.cacao.geometry.Rectangle

abstract class RenderObject {
    abstract val paintBounds: Rectangle

    abstract fun paint(context: PaintingContext)
}