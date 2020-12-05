package examples.graphics

import packages.cacao_graphics.*
import packages.cacao_graphics.implementations.*

public fun main() {
    val size = Size(600, 375)
    val graphics = AwtGraphics(size)
    val frame = Frame()

    /*val rectangle = Rectangle(0, 0, 20, 20)
    frame.drawRectangle(rectangle)
    val text = Text(21, 0, "hola!")
    frame.drawText(text)
    val text2 = Text(50, 0, "hello!", Font(50, java.awt.Font.MONOSPACED))
    frame.useColor(Color("#5a5a9a"))
    frame.drawText(text2)
    val rectangle2 = Rectangle(200,0,50,15)
    frame.drawRectangle(rectangle2)*/

    /*
    * Button
    * Rectangle[ w:60, h:20, fill:#c4c4c4, stroke:#000000-3-inside, shadow ]
    * Text[ w:60, h:20, fill:#000000, font:Roboto-12, text-align:center, align:middle ]
    * */
    val buttonBackground = Rectangle(0,0,60,20)
    val font = Font(12, "Roboto")
    val buttonText = Text(12,3,"Center", font)

    frame.drawRectangle(buttonBackground)
    frame.drawText(buttonText)

    graphics.drawFrame(frame)
}
