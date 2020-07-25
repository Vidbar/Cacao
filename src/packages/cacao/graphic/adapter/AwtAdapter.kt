package packages.cacao.graphic.adapter

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphic.IGraphicAdapter
import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess


typealias DrawingInstruction = (Graphics) -> Unit

class AwtAdapter(drawingSurface: Size) : Canvas(), IGraphicAdapter {
    private val drawingInstructions: MutableList<DrawingInstruction> = mutableListOf()
    private val defaultFont = Font("OpenSans", Font.PLAIN, 15)
    private val frame = Frame()
    init {
        frame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(evt: WindowEvent?) {
                exitProcess(0)
            }
        })
        frame.size = Dimension(drawingSurface.width.toInt(), drawingSurface.height.toInt())
        frame.isVisible = true
        frame.add(this)

        val instruction: DrawingInstruction = { graphics -> graphics.font = this.defaultFont }
        this.drawingInstructions.add(instruction)
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        for (instruction in this.drawingInstructions) {
            g?.let { instruction(it) }
        }
    }

    override val location: Point
        get() = Point(frame.location.x.toDouble(), frame.location.y.toDouble())

    override fun drawString(text: String, point: Point) {
        val instruction: DrawingInstruction = { graphics -> graphics.drawString(text, point.x.toInt(), point.y.toInt() + graphics.font.size) }
        this.drawingInstructions.add(instruction)
    }

    override fun drawRectangle(rectangle: Rectangle) {
        val x = rectangle.left.toInt()
        val y = rectangle.top.toInt()
        val width = (rectangle.right - rectangle.left).toInt()
        val height = (rectangle.bottom - rectangle.top).toInt()
        val instruction: DrawingInstruction = { graphics -> graphics.drawRect(x, y, width, height) }
        this.drawingInstructions.add(instruction)
    }

    override fun measureText(text: String): Size {
        val metrics = graphics.getFontMetrics(this.defaultFont)
        return Size(metrics.stringWidth(text).toDouble(), metrics.height.toDouble())
    }
}
