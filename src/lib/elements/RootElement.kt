package lib.elements

import lib.renderObjects.RenderObject
import lib.renderObjects.RenderView
import lib.widgets.RootWidget

class RootElement(private val rootWidget: RootWidget) : RenderObjectElement(rootWidget) {
    override val widget: RootWidget
        get() = super.widget as RootWidget

    val renderView: RenderView
        get() = super.renderObject as RenderView

    private var child: Element? = null

    override fun mount(parent: Element?) {
        super.mount(parent)
        this.rebuild()
    }

    override fun insertChildRenderObject(child: RenderObject) {
        this.renderView.child = child
    }

    private fun rebuild() {
        child = updateChild(child, widget.child)
    }
}
