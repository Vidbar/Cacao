package packages.cacao

import packages.cacao.geometry.Offset

class Canvas(private val adapter: IGraphicAdapter) {
    fun drawString(text: String, offset: Offset) {
        this.adapter.drawString(text, offset)
    }
}