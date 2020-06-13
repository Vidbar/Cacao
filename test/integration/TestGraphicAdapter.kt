package integration

import packages.cacao.IGraphicAdapter
import packages.cacao.geometry.Offset

class TestGraphicAdapter: IGraphicAdapter {
    override fun drawString(text: String, offset: Offset) {
    }
}