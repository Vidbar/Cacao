package packages.cacao

import packages.cacao.geometry.Offset

interface IGraphicAdapter {
    fun drawString(text: String, offset: Offset)
}
