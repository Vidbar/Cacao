package packages.cacao.widgets.basicWidgets

import packages.cacao.renderObjects.ClickEventListener
import packages.cacao.widgets.BasicWidget
import packages.cacao.widgets.Widget
import packages.cacao.widgets.renderWidgets.MouseListener
import packages.cacao.widgets.renderWidgets.Rectangle
import packages.cacao.widgets.renderWidgets.RichText

class Button(val text: String) : BasicWidget() {
    var onClick: ClickEventListener? = null

    override fun build(): Widget {
        return MouseListener(
            this.onClick,
            Rectangle(
                RichText(text)
            )
        )
    }
}
