package packages.cacao

import packages.cacao.elements.Element
import packages.cacao.elements.RenderObjectElement
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget
import packages.cacao.widgets.Widget

lateinit var rootElement: Element
private val renderView: RenderView = RenderView(400.0, 400.0)

fun run(app: Widget) {
    attachRootWidget(app)
    render()
}

private fun attachRootWidget(app: Widget) {
    val rootWidget = RootWidget(renderView, app)
    rootElement = rootWidget.createElement()
    rootElement.mount(null)
}

private fun render() {
    val renderObjectElement = rootElement as RenderObjectElement
    renderObjectElement.renderObject?.let { repaintCompositeChild(it) }
}