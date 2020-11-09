package packages.cacao_graphics

private typealias Instruction = (IFrameDrawer) -> Unit

public class Frame {
    private val _instructions: MutableList<Instruction> = mutableListOf()
    public val instructions: List<Instruction>
        get() = this._instructions

    public fun drawRectangle(rectangle: Rectangle) {
        this._instructions.add { drawer -> drawer.drawRectangle(rectangle) }
    }

    public fun drawText(text: Text) {
        this._instructions.add { drawer -> drawer.drawText(text) }
    }
}
