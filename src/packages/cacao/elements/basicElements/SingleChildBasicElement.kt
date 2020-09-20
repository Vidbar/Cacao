package packages.cacao.elements.basicElements

import packages.cacao.elements.Element
import packages.cacao.widgets.BasicWidget

open class SingleChildBasicElement(widget: BasicWidget) : BasicElement(widget) {
    var child: Element? = null

    override fun performRebuild() {
        val built = this.build()
        this.child = updateChild(this.child, built)
    }
}
