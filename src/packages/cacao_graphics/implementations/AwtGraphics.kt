package packages.cacao_graphics.implementations

import packages.cacao_graphics.*
import packages.cacao_graphics.Frame
import packages.cacao_graphics.Graphics
import packages.cacao_graphics.Rectangle
import java.awt.*
import java.awt.Font
import java.awt.RenderingHints
import java.awt.event.*
import kotlin.system.*

public class AwtGraphics(size: Size) : Graphics(size) {
    override fun initFrameDrawer(size: Size): IFrameDrawer {
        val window = java.awt.Frame()
        val canvas = AwtCanvas()
        window.add(canvas)

        window.addWindowListener(object : WindowAdapter() {
            override fun windowClosing(evt: WindowEvent?) {
                exitProcess(0)
            }
        })
        window.size = Dimension(size.width, size.height)
        window.isVisible = true

        return canvas
    }

    override fun calculateSurfaceSize(): Size {
        TODO("Not yet implemented")
    }

    override fun drawFrame(frame: Frame) {
        this.drawer.frame = frame
    }
}

private class AwtCanvas : Canvas(), IFrameDrawer {
    override var frame: Frame? = null
        set(value) {
            field = value
            this.repaint()
        }

    private var paintGraphics: java.awt.Graphics? = null
    override fun paint(graphics: java.awt.Graphics?) {
        super.paint(graphics)
        this.paintGraphics = graphics

        this.initializeRenderingHints(graphics as Graphics2D)

        this.frame?.let {
            this.drawFrame(it)
        }

        this.paintGraphics = null
    }

    private fun initializeRenderingHints(graphics: Graphics2D?) {
        val rh = RenderingHints(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON)

        rh[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY

        graphics?.setRenderingHints(rh)
    }

    override fun drawFrame(frame: Frame) {
        frame.instructions.forEach {
            it(this)
        }
    }

    override fun drawRectangle(rectangle: Rectangle) {
        this.paintGraphics?.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
    }

    override fun drawText(text: Text) {
        val font = Font(text.font.fontFamily, Font.PLAIN, text.font.fontSize)
        this.paintGraphics?.font = font
        this.paintGraphics?.drawString(text.value, text.x, text.y + font.size)
    }
}