package packages.cacao.widgets.basicWidgets

import packages.cacao.widgets.BasicWidget
import packages.cacao.widgets.Widget
import packages.cacao.widgets.renderWidgets.RichText

class Text(val text: String) : BasicWidget() {
    override fun build(): Widget {
        return RichText(text)
    }
}
