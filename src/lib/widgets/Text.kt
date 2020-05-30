package lib.widgets

class Text(private val text: String) : StatelessWidget() {
    override fun build(): Widget {
        return RichText(text)
    }
}