package packages.cacao.geometry

public class Point(public val x: Double, public val y: Double) {
    public companion object {
        public val zero: Point = Point(0.0, 0.0)
    }

    public operator fun plus(size: Size): Rectangle = Rectangle(x, y, x + size.width, y + size.height)
    public operator fun minus(point: Point): Point = Point(this.x - point.x, this.y - point.y)
}
