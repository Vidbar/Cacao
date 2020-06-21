package packages.cacao.renderObjects

import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext

class RenderView(private val configurationSize: Size) : SingleChildRenderObject() {
    override var size: Size = configurationSize

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }

    override fun performLayout() {
        this.child?.let { it.layout(this.size) }
    }
}