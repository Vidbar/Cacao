package lib.widgets

import lib.renderObjects.RenderObject

abstract class RenderObjectWidget : Widget() {
    abstract fun createRenderObject(): RenderObject
}