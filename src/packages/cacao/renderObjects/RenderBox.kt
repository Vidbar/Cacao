package packages.cacao.renderObjects

import packages.cacao.events.Event
import packages.cacao.geometry.Point
import packages.cacao.listeners.HitTestResult
import packages.cacao.listeners.IHitTestTarget
import packages.cacao.listeners.IHitTestable

abstract class RenderBox : RenderObject(), IHitTestable, IHitTestTarget {
    override fun hitTest(result: HitTestResult, position: Point) {
        if (this.size.contains(position)) {
            result.add(this)
            this.hitTestChildren(result, position)
        }
    }

    open fun hitTestChildren(result: HitTestResult, position: Point) {
        // override this method if this render object has children.
    }

    override fun handleEvent(event: Event) {
        // override this method to handle mouse events that hit this render object.
    }
}
