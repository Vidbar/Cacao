package packages.cacao.renderObjects

import packages.cacao.geometry.Offset
import packages.cacao.listeners.HitTestResult
import packages.cacao.listeners.IHitTestable

abstract class RenderBox : RenderObject(), IHitTestable {
    override fun hitTest(result: HitTestResult, position: Offset)/*: Boolean*/ {
        if (this.size.contains(position)) {
            if (this.hitTestChildren(result, position)) {
                result.add(this)
                //return true
            }
        }
        //return false
    }

    protected fun hitTestChildren(result: HitTestResult, position: Offset): Boolean = false
}
