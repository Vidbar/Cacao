package lib

import lib.elements.Element
import lib.elements.RenderObjectElement
import lib.renderObjects.RenderView
import lib.widgets.RootWidget
import lib.widgets.Widget

class Environment {
    lateinit var rootElement: Element
    private val renderView: RenderView = RenderView(400.0, 400.0)

    fun attachRootWidget(app: Widget) {
        val rootWidget = RootWidget(this.renderView, app)
        this.rootElement = rootWidget.createElement()
        this.rootElement.mount(null)
    }

    fun render() {
        val renderObjectElement = this.rootElement as RenderObjectElement
        renderObjectElement.renderObject?.let { repaintCompositeChild(it) }
    }
}