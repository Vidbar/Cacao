package packages.cacao.renderObjects

import packages.cacao.geometry.Point
import packages.cacao.listeners.HitTestResult

public abstract class SingleChildRenderObject : RenderObject() {
    public var child: RenderObject? = null

    override fun hitTestChildren(result: HitTestResult, position: Point) {
        this.child?.hitTest(result, position)
    }
}
