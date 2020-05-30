package lib

import lib.geometry.Offset

interface IGraphicsAdapter {
    fun drawString(text: String, offset: Offset)
}
