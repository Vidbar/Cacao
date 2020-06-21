package packages.cacao.graphic

import packages.cacao.Canvas
import packages.cacao.geometry.Rectangle
import packages.cacao.geometry.Size
import packages.cacao.graphic.adapter.AwtAdapter
import packages.cacao.renderObjects.RenderObject

private var graphicAdapterConstructor: (Size) -> IGraphicAdapter = { size: Size -> AwtAdapter(size) }

lateinit var adapter: IGraphicAdapter

fun initGraphicAdapter(size: Size){
    adapter = graphicAdapterConstructor(size)
}

class PaintingContext(private val paintBounds: Rectangle) {
    val canvas: Canvas = Canvas(adapter)

    fun paintChild(child: RenderObject) {
        child.paint(this)
    }
}

fun repaintCompositeChild(child: RenderObject) {
    val rectangle = Rectangle(0.0,0.0, child.size.width, child.size.height)
    val context = PaintingContext(rectangle)
    child.paint(context)
}

fun changeGraphicAdapter(newGraphicAdapter: (Size) -> IGraphicAdapter) {
    graphicAdapterConstructor = newGraphicAdapter
}