package packages.cacao.widgets

import packages.cacao.renderObjects.RenderObject

abstract class RenderObjectWidget : Widget() {
    abstract fun createRenderObject(): RenderObject
}