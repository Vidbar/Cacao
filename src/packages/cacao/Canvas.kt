package packages.cacao

import packages.cacao.geometry.Offset
import packages.cacao.geometry.Rectangle
import packages.cacao.graphic.IGraphicAdapter

class Canvas(private val adapter: IGraphicAdapter) {
    fun drawString(text: String, offset: Offset) {
        this.adapter.drawString(text, offset)
    }

    fun drawRectangle(rectangle: Rectangle) {
        this.adapter.drawRectangle(rectangle)
    }
}