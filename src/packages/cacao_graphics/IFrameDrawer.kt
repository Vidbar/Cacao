package packages.cacao_graphics

public interface IFrameDrawer {
    public var frame: Frame?
    public fun drawFrame(frame: Frame)
    public fun drawRectangle(rectangle: Rectangle)
    public fun drawText(text: Text)
}