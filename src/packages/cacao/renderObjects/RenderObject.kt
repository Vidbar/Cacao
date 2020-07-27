package packages.cacao.renderObjects

import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.listeners.IHitTestTarget

abstract class RenderObject {
    abstract var size: Size

    abstract fun paint(context: PaintingContext)
    abstract fun performLayout()

    fun layout(size: Size){
        this.performLayout()
    }
}