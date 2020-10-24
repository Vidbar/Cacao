package packages.cacao_driver.extension

import packages.cacao.Cacao
import packages.cacao.elements.Element
import packages.cacao.widgets.Widget
import packages.cacao.widgets.basicWidgets.Text

public class WidgetTypeFinder(private val type: String) : MatchFinder() {
    override fun matches(candidate: Element): Boolean {
        return candidate.widget::class.simpleName == type
    }
}

public class TextFinder(public val text: String) : MatchFinder() {
    override fun matches(candidate: Element): Boolean {
        val widget: Widget = candidate.widget
        if (widget is Text) {
            return widget.text == text
        }
        return false
    }
}

public abstract class MatchFinder : Finder() {
    public abstract fun matches(candidate: Element): Boolean

    override fun apply(candidates: List<Element>): List<Element> {
        return candidates.toMutableList().filter { matches(it) }
    }
}

public abstract class Finder {
    private val allCandidates: List<Element>
        get() = this.collectAllElementsFrom(Cacao.instance.rootElement)

    private fun collectAllElementsFrom(rootElement: Element): List<Element> {
        val children = mutableListOf<Element>()
        rootElement.visitChildren(children::add)
        return children
    }

    public abstract fun apply(candidates: List<Element>): List<Element>

    public fun evaluate(): List<Element> {
        return apply(this.allCandidates)
    }
}