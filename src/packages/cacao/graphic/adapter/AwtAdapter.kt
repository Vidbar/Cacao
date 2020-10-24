package packages.cacao.graphic.adapter

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphic.IGraphicAdapter
import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess

public typealias DrawingInstruction = (Graphics) -> Unit

public class AwtAdapter(drawingSurface: Size) : IGraphicAdapter {
    private val frame = Frame()
    private val awtCanvas = AwtCanvas()

    init {
        this.frame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(evt: WindowEvent?) {
                exitProcess(0)
            }
        })
        this.frame.size = Dimension(drawingSurface.width.toInt(), drawingSurface.height.toInt())
        this.frame.isVisible = true
        this.frame.add(this.awtCanvas)
    }

    override val location: Point
        get() = Point(this.frame.location.x.toDouble(), this.getContentPositionY())

    private fun getContentPositionY(): Double {
        return this.frame.location.y.toDouble() + this.frame.insets.top
    }

    override fun drawString(text: String, point: Point) {
        this.awtCanvas.drawString(text, point)
    }

    override fun drawRectangle(rectangle: Rectangle) {
        this.awtCanvas.drawRectangle(rectangle)
    }

    override fun measureText(text: String): Size {
        return this.awtCanvas.measureText(text)
    }

    override fun clean() {
        this.awtCanvas.cleanDrawingInstructions()
    }
}

public class AwtCanvas : Canvas() {
    private val drawingInstructions: MutableList<DrawingInstruction> = mutableListOf()
    private val defaultFont = Font("OpenSans", Font.PLAIN, 15)

    override fun paint(graphics: Graphics?) {
        super.paint(graphics)

        graphics?.let { this.useDefaultFont(it) }
        for (instruction in this.drawingInstructions) {
            graphics?.let { instruction(it) }
        }
    }

    private fun useDefaultFont(graphics: Graphics) {
        graphics.font = this.defaultFont
    }

    public fun drawString(text: String, point: Point) {
        val instruction: DrawingInstruction =
            { graphics -> graphics.drawString(text, point.x.toInt(), point.y.toInt() + graphics.font.size) }
        this.drawingInstructions.add(instruction)
        this.repaint()
    }

    public fun drawRectangle(rectangle: Rectangle) {
        val x = rectangle.left.toInt()
        val y = rectangle.top.toInt()
        val width = (rectangle.right - rectangle.left).toInt()
        val height = (rectangle.bottom - rectangle.top).toInt()
        val instruction: DrawingInstruction = { graphics -> graphics.drawRect(x, y, width, height) }
        this.drawingInstructions.add(instruction)
        this.repaint()
    }

    public fun measureText(text: String): Size {
        val metrics = graphics.getFontMetrics(this.defaultFont)
        return Size(metrics.stringWidth(text).toDouble(), metrics.height.toDouble())
    }

    public fun cleanDrawingInstructions() {
        this.drawingInstructions.clear()
    }
}
