package packages.cacao.geometry

class Size(val width: Double, val height: Double) {
    fun contains(offset: Offset): Boolean {
        return offset.dx >= 0.0 && offset.dx < this.width && offset.dy >= 0.0 && offset.dy < this.height
    }

    companion object {
        val zero = Size(0.0, 0.0)
    }
}