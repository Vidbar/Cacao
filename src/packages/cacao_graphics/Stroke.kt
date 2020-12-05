package packages.cacao_graphics

import packages.cacao.painting.*

public enum class StrokePosition{
    Inside,
    Center,
    Outside
}

private val black = Color(0,0,0,255)

public class Stroke(
    public val color: Color = black,
    public val width: Int= 1,
    public val position: StrokePosition = StrokePosition.Inside)