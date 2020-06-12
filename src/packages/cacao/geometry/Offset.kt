package packages.cacao.geometry

class Offset(val dx: Double, val dy: Double) {
    companion object {
        val zero = Offset(0.0, 0.0)
    }

    operator fun plus(size: Size): Rectangle = Rectangle(dx, dy, dx + size.width, dy + size.height)
}