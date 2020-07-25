package packages.cacao.listeners

import org.jnativehook.mouse.NativeMouseEvent
import org.jnativehook.mouse.NativeMouseListener
import packages.cacao.geometry.Point

class MouseListener(private val hitTestable: IHitTestable): NativeMouseListener {
    override fun nativeMousePressed(mouseEvent: NativeMouseEvent?) {
        println("mouse pressed")
    }

    override fun nativeMouseClicked(mouseEvent: NativeMouseEvent?) {
        println("mouse clicked")
        val hitTestResult = HitTestResult()
        val position = if (mouseEvent != null) Point(mouseEvent.x.toDouble(), mouseEvent.y.toDouble()) else Point.zero
        this.hitTestable.hitTest(hitTestResult, position)
    }

    override fun nativeMouseReleased(mouseEvent: NativeMouseEvent?) {
        println("mouse released")
    }
}