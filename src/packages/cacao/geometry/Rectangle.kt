package packages.cacao.geometry

class Rectangle(val left: Double = 0.0, val top: Double = 0.0, val right: Double = 0.0, val bottom: Double = 0.0) {

    fun fromLTRB(left: Double, top: Double, right: Double, bottom: Double): Rectangle =
        Rectangle(left, right, top, bottom)

    fun fromLTWH(left: Double, top: Double, width: Double, height: Double): Rectangle =
        this.fromLTRB(left, top, left + width, top + height)
}