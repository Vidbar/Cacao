package packages.cacao.graphic

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

public interface IGraphicAdapter {
    public val location: Point

    public fun drawString(text: String, point: Point)
    public fun drawRectangle(rectangle: Rectangle)
    public fun measureText(text: String): Size
    public fun clean()
}
