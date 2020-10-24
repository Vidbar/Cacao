package packages.cacao.geometry

public class Rectangle(public val left: Double = 0.0, public val top: Double = 0.0, public val right: Double = 0.0, public val bottom: Double = 0.0) {

    private fun fromLTRB(left: Double, top: Double, right: Double, bottom: Double): Rectangle =
        Rectangle(left, right, top, bottom)

    public fun fromLTWH(left: Double, top: Double, width: Double, height: Double): Rectangle =
        this.fromLTRB(left, top, left + width, top + height)
}
