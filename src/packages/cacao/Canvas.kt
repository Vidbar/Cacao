package packages.cacao

import packages.cacao.geometry.Offset

class Canvas(private val adapter: IGraphicsAdapter) {
    fun drawString(text: String, offset: Offset) {
        this.adapter.drawString(text, offset)
    }
}