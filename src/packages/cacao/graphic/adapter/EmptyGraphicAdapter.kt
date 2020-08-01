package packages.cacao.graphic.adapter

import packages.cacao.graphic.IGraphicAdapter
import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

class EmptyGraphicAdapter: IGraphicAdapter {
    override val location: Point
        get() = Point.zero

    override fun drawString(text: String, point: Point) {
    }

    override fun drawRectangle(rectangle: Rectangle) {
    }

    override fun measureText(text: String): Size {
        return Size.zero
    }
}