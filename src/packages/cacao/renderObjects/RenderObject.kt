package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.listeners.HitTestResult

public abstract class RenderObject {
    public abstract var size: Size

    public abstract fun paint(context: PaintingContext)
    public abstract fun performLayout()

    public fun layout(size: Size) {
        this.performLayout()
    }

    public open fun hitTest(result: HitTestResult, position: Point) {
        if (this.size.contains(position)) {
            result.add(this)
            this.hitTestChildren(result, position)
        }
    }

    public open fun hitTestChildren(result: HitTestResult, position: Point) {
        // override this method if this render object has children.
    }
}
