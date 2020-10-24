package packages.cacao.widgets

import packages.cacao.renderObjects.RenderObject

public abstract class RenderWidget : Widget() {
    public abstract fun createRenderObject(): RenderObject

    public open fun updateRenderObject(renderObject: RenderObject) {}
}
