package packages.cacao.graphic.adapter

import packages.cacao.geometry.Point
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphic.IGraphicAdapter
import java.awt.Dimension
import java.awt.Font
import java.awt.Graphics
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class SwingAdapter(size: Size) : JFrame(), IGraphicAdapter {
    private val panel: Panel = Panel()
    override val location: Point
        get() {
            val titleBarHeight = this.size.height - this.contentPane.size.height
            val y = this.getLocation().getY() + titleBarHeight
            return Point(this.getLocation().getX(), y)
        }

    init {
        this.add(this.panel)
        this.size = Dimension(size.width.toInt(), size.height.toInt())
        this.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        this.isVisible = true
    }

    override fun drawString(text: String, point: Point) {
        this.panel.drawString(text, point)
        this.panel.repaint()
    }

    override fun drawRectangle(rectangle: Rectangle) {
        this.panel.drawRectangle(rectangle)
        this.panel.repaint()
    }

    override fun measureText(text: String): Size {
        return this.panel.measureText(text)
    }
}

class Panel : JPanel() {

    private val drawingInstructions: MutableList<DrawingInstruction> = mutableListOf()
    private val defaultFont = Font("OpenSans", Font.PLAIN, 15)

    init {
        val instruction: DrawingInstruction = { graphics -> graphics.font = this.defaultFont }
        this.drawingInstructions.add(instruction)
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        for (instruction in this.drawingInstructions) {
            g?.let { instruction(it) }
        }
    }

    fun drawString(text: String, point: Point) {
        val instruction: DrawingInstruction =
            { graphics -> graphics.drawString(text, point.x.toInt(), point.y.toInt() + graphics.font.size) }
        this.drawingInstructions.add(instruction)
    }

    fun drawRectangle(rectangle: Rectangle) {
        val x = rectangle.left.toInt()
        val y = rectangle.top.toInt()
        val width = (rectangle.right - rectangle.left).toInt()
        val height = (rectangle.bottom - rectangle.top).toInt()
        val instruction: DrawingInstruction = { graphics -> graphics.drawRect(x, y, width, height) }
        this.drawingInstructions.add(instruction)
    }

    fun measureText(text: String): Size {
        val metrics = graphics.getFontMetrics(this.defaultFont)
        return Size(metrics.stringWidth(text).toDouble(), metrics.height.toDouble())
    }
}
