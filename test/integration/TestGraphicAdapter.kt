package integration

import packages.cacao.graphic.IGraphicAdapter
import packages.cacao.geometry.Offset
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

class TestGraphicAdapter: IGraphicAdapter {
    override fun drawString(text: String, offset: Offset) {
    }

    override fun drawRectangle(rectangle: Rectangle) {
    }

    override fun measureText(text: String): Size {
        return Size.zero
    }
}