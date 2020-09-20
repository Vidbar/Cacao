package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.listeners.HitTestResult

abstract class RenderObject {
    abstract var size: Size

    abstract fun paint(context: PaintingContext)
    abstract fun performLayout()

    fun layout(size: Size) {
        this.performLayout()
    }

    open fun hitTest(result: HitTestResult, position: Point) {
        if (this.size.contains(position)) {
            result.add(this)
            this.hitTestChildren(result, position)
        }
    }

    open fun hitTestChildren(result: HitTestResult, position: Point) {
        // override this method if this render object has children.
    }
}
