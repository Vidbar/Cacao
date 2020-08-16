package packages.cacao.geometry

class Point(val x: Double, val y: Double) {
    companion object {
        val zero = Point(0.0, 0.0)
    }

    operator fun plus(size: Size): Rectangle = Rectangle(x, y, x + size.width, y + size.height)
    operator fun minus(point: Point): Point = Point(this.x - point.x, this.y - point.y)
}
