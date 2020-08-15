package packages.cacao.elements

import packages.cacao.renderObjects.RenderObject
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget

class RootElement(private val rootWidget: RootWidget) : RenderElement(rootWidget) {
    override val widget: RootWidget
        get() = super.widget as RootWidget

    private val renderView: RenderView
        get() = super.renderObject as RenderView

    private var child: Element? = null

    override fun mount(parent: Element?) {
        super.mount(parent)

        this.child = updateChild(this.child, this.widget.child)
    }

    override fun insertChildRenderObject(child: RenderObject) {
        this.renderView.child = child
    }

    override fun visitChildren(visitor: ElementVisitor) {
        this.child?.let { visitor(it) }
    }
}
