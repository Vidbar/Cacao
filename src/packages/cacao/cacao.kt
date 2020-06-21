package packages.cacao

import packages.cacao.elements.Element
import packages.cacao.elements.RenderElement
import packages.cacao.geometry.Size
import packages.cacao.graphic.initGraphicAdapter
import packages.cacao.graphic.repaintCompositeChild
import packages.cacao.renderObjects.RenderView
import packages.cacao.widgets.RootWidget
import packages.cacao.widgets.Widget

lateinit var rootElement: Element

private val configurationSize = Size(400.0,400.0) //TODO
private val renderView: RenderView = RenderView(configurationSize)

fun run(app: Widget) {
    attachRootWidget(app)
    initializeGraphic()
    layout()
    render()
}

fun initializeGraphic() {
    initGraphicAdapter(configurationSize)
}

private fun attachRootWidget(app: Widget) {
    val rootWidget = RootWidget(renderView, app)
    rootElement = rootWidget.createElement()
    rootElement.mount(null)
}

private fun layout(){
    val renderElement = rootElement as RenderElement
    renderElement.renderObject?.performLayout()
}

private fun render() {
    val renderElement = rootElement as RenderElement
    renderElement.renderObject?.let { repaintCompositeChild(it) }
}