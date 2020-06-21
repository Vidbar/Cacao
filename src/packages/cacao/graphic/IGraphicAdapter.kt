package packages.cacao.graphic

import packages.cacao.geometry.Offset
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

interface IGraphicAdapter {
    fun drawString(text: String, offset: Offset)
    fun drawRectangle(rectangle: Rectangle)
    fun measureText(text: String): Size
}
