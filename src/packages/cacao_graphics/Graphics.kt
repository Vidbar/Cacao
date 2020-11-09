package packages.cacao_graphics

public abstract class Graphics(public val size: Size) {
    protected val drawer: IFrameDrawer

    init {
        drawer = initFrameDrawer(size)
    }

    public val surfaceSize: Size
        get() = this.calculateSurfaceSize()

    public abstract fun initFrameDrawer(size: Size): IFrameDrawer
    public abstract fun calculateSurfaceSize(): Size
    public abstract fun drawFrame(frame: Frame)
}
