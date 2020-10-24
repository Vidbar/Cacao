package packages.cacao.widgets.basicWidgets

import packages.cacao.renderObjects.ClickEventListener
import packages.cacao.widgets.BasicWidget
import packages.cacao.widgets.Widget
import packages.cacao.widgets.renderWidgets.MouseListener
import packages.cacao.widgets.renderWidgets.Rectangle
import packages.cacao.widgets.renderWidgets.RichText

public class Button(public val text: String) : BasicWidget() {
    public var onClick: ClickEventListener? = null

    override fun build(): Widget {
        return MouseListener(
            this.onClick,
            Rectangle(
                RichText(text)
            )
        )
    }
}
