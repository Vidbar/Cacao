package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget

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

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }
}
