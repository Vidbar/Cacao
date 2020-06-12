package packages.cacao.renderObjects

import packages.cacao.PaintingContext
import packages.cacao.geometry.Offset

class RenderText(private val text: String) : RenderBox() {
    override fun paint(context: PaintingContext) {
        context.canvas.drawString(text, Offset.zero)
    }
}