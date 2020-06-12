package packages.cacao.widgets

class Text(val text: String) : StatelessWidget() {
    override fun build(): Widget {
        return RichText(text)
    }
}