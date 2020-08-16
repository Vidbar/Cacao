package packages.cacao.widgets

import packages.cacao.widgets.renderWidgets.RichText

class Text(val text: String) : StatelessWidget() {
    override fun build(): Widget {
        return RichText(text)
    }
}