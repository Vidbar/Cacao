package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.graphic.adapter
import packages.cacao.listeners.HitTestResult

class ViewRenderObject(private val configurationSize: Size) : SingleChildRenderObject() {
    override var size: Size = configurationSize
    private val location: Point
        get() = adapter.location

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }

    override fun performLayout() {
        this.child?.let { it.layout(this.size) }
    }

    override fun hitTest(result: HitTestResult, position: Point) {
        val surfacePosition = position - this.location
        super.hitTest(result, surfacePosition)
    }
}
