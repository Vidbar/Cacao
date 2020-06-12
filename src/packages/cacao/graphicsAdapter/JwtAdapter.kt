package packages.cacao.graphicsAdapter

import packages.cacao.IGraphicsAdapter
import packages.cacao.geometry.Offset
import packages.cacao.geometry.Size
import java.awt.*
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import kotlin.system.exitProcess


typealias DrawingInstruction = (Graphics) -> Unit

class JwtAdapter(drawingSurface: Size) : Canvas(), IGraphicsAdapter {
    private val drawingInstructions: MutableList<DrawingInstruction> = mutableListOf()

    init {
        val frame = Frame()
        frame.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(evt: WindowEvent?) {
                exitProcess(0)
            }
        })
        frame.size = Dimension(drawingSurface.width.toInt(), drawingSurface.height.toInt())
        frame.isVisible = true
        frame.add(this)

        val instruction: DrawingInstruction = { graphics -> graphics.font = Font("OpenSans", Font.PLAIN, 15) }
        this.drawingInstructions.add(instruction)
    }

    override fun paint(g: Graphics?) {
        super.paint(g)
        for (instruction in this.drawingInstructions) {
            g?.let { instruction(it) }
        }
    }

    override fun drawString(text: String, offset: Offset) {
        val instruction: DrawingInstruction = { graphics -> graphics.drawString(text, offset.dx.toInt(), offset.dy.toInt() + graphics.font.size) }
        this.drawingInstructions.add(instruction)
    }
}
