package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.graphic.adapter
import packages.cacao.listeners.HitTestResult
import packages.cacao.listeners.IHitTestable

class RenderView(private val configurationSize: Size) : SingleChildRenderObject() {
    override var size: Size = configurationSize
    private val location: Point
        get() = adapter.location

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }

    override fun performLayout() {
        this.child?.let { it.layout(this.size) }
    }

    override fun handleEvent() {
        TODO("Not yet implemented")
    }

    override fun hitTest(result: HitTestResult, position: Point) {
        val surfacePosition = position - this.location
        if (this.size.contains(surfacePosition)) {
            this.child?.let {
                if (it is IHitTestable) {
                    it.hitTest(result, surfacePosition)
                }
            }
            result.add(this)
        }
    }
}