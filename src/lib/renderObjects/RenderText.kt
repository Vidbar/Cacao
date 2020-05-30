package lib.renderObjects

import lib.PaintingContext
import lib.geometry.Offset

class RenderText(private val text: String) : RenderBox() {
    override fun paint(context: PaintingContext) {
        context.canvas.drawString(text, Offset.zero)
    }
}