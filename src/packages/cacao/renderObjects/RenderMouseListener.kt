package packages.cacao.renderObjects

import packages.cacao.events.ClickEvent
import packages.cacao.events.Event
import packages.cacao.geometry.Size
import packages.cacao.graphic.PaintingContext

typealias ClickEventListener = (Event) -> Unit

class RenderMouseListener(
    private val onClick: ClickEventListener?
) : SingleChildRenderObject() {
    override lateinit var size: Size

    override fun paint(context: PaintingContext) {
        child?.let { context.paintChild(it) }
    }

    override fun performLayout() {
        this.child?.let {
            it.layout(Size.zero)
            this.size = it.size
        }
    }

    override fun handleEvent(event: Event) {
        when (event) {
            is ClickEvent -> if (this.onClick != null) {
                this.onClick.invoke(event)
            }
        }
    }
}