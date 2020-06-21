package packages.cacao.widgets

class Button(var child: Widget) : StatelessWidget() {
    var onClick: Function<Unit>? = null

    override fun build(): Widget {
        return Border(this.child)
    }
}

fun button(child: Widget, initializer: Button.() -> Unit): Button {
    return Button(child).apply(initializer)
}