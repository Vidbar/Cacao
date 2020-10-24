package packages.cacao.geometry

public class Size(public val width: Double, public val height: Double) {
    public fun contains(point: Point): Boolean {
        return point.x >= 0.0 && point.x < this.width && point.y >= 0.0 && point.y < this.height
    }

    public companion object {
        public val zero: Size = Size(0.0, 0.0)
    }
}
