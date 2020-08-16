package packages.cacao.widgets

import packages.cacao.renderObjects.ClickEventListener
import packages.cacao.widgets.renderWidgets.MouseListenerRenderWidget

class Button(var child: Widget) : StatelessWidget() {
    var onClick: ClickEventListener? = null

    override fun build(): Widget {
        return MouseListenerRenderWidget(
            this.onClick,
            Border(this.child)
        )
    }
}

fun button(child: Widget, initializer: Button.() -> Unit): Button {
    return Button(child).apply(initializer)
}
