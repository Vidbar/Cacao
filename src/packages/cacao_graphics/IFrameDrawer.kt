package packages.cacao_graphics

import packages.cacao.painting.*

public interface IFrameDrawer {
    public var frame: Frame?
    public fun drawFrame(frame: Frame)
    public fun drawRectangle(rectangle: Rectangle)
    public fun drawText(text: Text)
    public fun useColor(color: Color)
}