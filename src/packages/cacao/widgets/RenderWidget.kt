package packages.cacao.widgets

import packages.cacao.renderObjects.RenderObject

abstract class RenderWidget : Widget() {
    abstract fun createRenderObject(): RenderObject
}