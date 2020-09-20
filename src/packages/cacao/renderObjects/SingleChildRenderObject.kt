package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.listeners.HitTestResult

abstract class SingleChildRenderObject : RenderObject() {
    var child: RenderObject? = null

    override fun hitTestChildren(result: HitTestResult, position: Point) {
        this.child?.hitTest(result, position)
    }
}
