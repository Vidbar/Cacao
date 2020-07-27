package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.listeners.HitTestResult

abstract class SingleChildRenderObject : RenderBox() {
    var child: RenderObject? = null

    override fun hitTestChildren(result: HitTestResult, position: Point) {
        this.child?.let {
            if(it is RenderBox){
                it.hitTest(result, position)
            }
        }
    }
}
