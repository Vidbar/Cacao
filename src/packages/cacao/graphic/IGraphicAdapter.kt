package packages.cacao.graphic

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

interface IGraphicAdapter {
    val location: Point

    fun drawString(text: String, point: Point)
    fun drawRectangle(rectangle: Rectangle)
    fun measureText(text: String): Size
}
