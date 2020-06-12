package packages.cacao

import packages.cacao.geometry.Offset

interface IGraphicsAdapter {
    fun drawString(text: String, offset: Offset)
}
