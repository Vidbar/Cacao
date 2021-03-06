package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext
import packages.cacao.graphic.adapter

public class RichTextRenderObject(public var text: String) : LeafRenderObject() {
    override lateinit var size: Size
    override fun paint(context: PaintingContext) {
        context.canvas.drawString(text, Point.zero)
    }

    override fun performLayout() {
        this.size = adapter.measureText(text)
    }
}
