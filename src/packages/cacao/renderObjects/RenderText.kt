package packages.cacao.renderObjects

import packages.cacao.graphic.PaintingContext
import packages.cacao.geometry.Offset
import packages.cacao.geometry.Size
import packages.cacao.graphic.adapter

class RenderText(private val text: String) : RenderObject() {
    override lateinit var size: Size
    override fun paint(context: PaintingContext) {
        context.canvas.drawString(text, Offset.zero)
    }

    override fun performLayout() {
        this.size = adapter.measureText(text)
    }
}