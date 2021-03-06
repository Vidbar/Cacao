package packages.cacao.listeners

import org.jnativehook.mouse.NativeMouseEvent
import org.jnativehook.mouse.NativeMouseListener
import packages.cacao.events.ClickEvent
import packages.cacao.events.Event
import packages.cacao.geometry.Point
import packages.cacao.renderObjects.RenderObject

public class GlobalMouseListener(private val hitTestable: RenderObject) : NativeMouseListener {
    override fun nativeMousePressed(mouseEvent: NativeMouseEvent?) {
        println("mouse pressed")
    }

    override fun nativeMouseClicked(mouseEvent: NativeMouseEvent?) {
        println("mouse clicked")
        if (mouseEvent != null) {
            val position = Point(mouseEvent.x.toDouble(), mouseEvent.y.toDouble())
            val clickEvent = ClickEvent(position)
            this.handleMouseEvent(clickEvent)
        }
    }

    override fun nativeMouseReleased(mouseEvent: NativeMouseEvent?) {
        println("mouse released")
    }

    private fun handleMouseEvent(clickEvent: ClickEvent) {
        val hitTestResult = HitTestResult()
        this.hitTestable.hitTest(hitTestResult, clickEvent.position)
        this.dispatchEvent(clickEvent, hitTestResult)
    }

    private fun dispatchEvent(event: Event, hitTestResult: HitTestResult) {
        for (entry in hitTestResult.path.filter { it is IHitTestTarget }) {
            (entry as IHitTestTarget).handleEvent(event)
        }
    }
}
