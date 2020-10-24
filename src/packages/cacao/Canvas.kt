package packages.cacao

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.graphic.IGraphicAdapter

public class Canvas(private val adapter: IGraphicAdapter) {
    init {
        adapter.clean()
    }

    public fun drawString(text: String, point: Point) {
        this.adapter.drawString(text, point)
    }

    public fun drawRectangle(rectangle: Rectangle) {
        this.adapter.drawRectangle(rectangle)
    }
}
