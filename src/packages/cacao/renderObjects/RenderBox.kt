package packages.cacao.renderObjects

import packages.cacao.geometry.Offset
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size

abstract class RenderBox : RenderObject() {
    var size = Size.zero
    override val paintBounds: Rectangle
        get() = Offset.zero + size
}