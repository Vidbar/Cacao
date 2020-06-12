package packages.cacao.widgets

class Button(private val text: String) : StatelessWidget() {
    override fun build(): Widget {
        return BorderBox(RichText(text))
    }
}