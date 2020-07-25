package packages.cacao.geometry

class Size(val width: Double, val height: Double) {
    fun contains(point: Point): Boolean {
        return point.x >= 0.0 && point.x < this.width && point.y >= 0.0 && point.y < this.height
    }

    companion object {
        val zero = Size(0.0, 0.0)
    }
}