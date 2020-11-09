package examples.graphics

import packages.cacao_graphics.*
import packages.cacao_graphics.implementations.*

public fun main() {
    val size = Size(600, 375)
    val graphics = AwtGraphics(size)
    val frame = Frame()

    val rectangle = Rectangle(0, 0, 20, 20)
    frame.drawRectangle(rectangle)
    val text = Text(21, 0, "hola!")
    frame.drawText(text)
    val text2 = Text(50, 0, "hello!", Font(50, java.awt.Font.MONOSPACED))
    frame.drawText(text2)

    graphics.drawFrame(frame)
}
