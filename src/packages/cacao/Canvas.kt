package packages.cacao

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.graphic.IGraphicAdapter

class Canvas(private val adapter: IGraphicAdapter) {
    fun drawString(text: String, point: Point) {
        this.adapter.drawString(text, point)
    }

    fun drawRectangle(rectangle: Rectangle) {
        this.adapter.drawRectangle(rectangle)
    }
}