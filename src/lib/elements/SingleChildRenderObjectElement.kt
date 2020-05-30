package lib.elements

import lib.renderObjects.RenderObject
import lib.renderObjects.RenderObjectWithChild
import lib.widgets.RenderObjectWidget

class SingleChildRenderObjectElement(widget: RenderObjectWidget) : RenderObjectElement(widget) {
    override fun insertChildRenderObject(child: RenderObject) {
        val renderObject = this.renderObject as RenderObjectWithChild
        renderObject.child = child
    }

}