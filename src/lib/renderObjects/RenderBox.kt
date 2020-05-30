package lib.renderObjects

import lib.geometry.Offset
import lib.geometry.Rectangle
import lib.geometry.Size

abstract class RenderBox : RenderObject() {
    var size = Size.zero
    override val paintBounds: Rectangle
        get() = Offset.zero + size
}