package packages.cacao_driver.extension

import packages.cacao.elements.Element
import packages.cacao.rootElement
import packages.cacao.widgets.Text
import packages.cacao.widgets.Widget
import kotlin.reflect.KClass

class WidgetTypeFinder(private val type: String) : MatchFinder() {
    override fun matches(candidate: Element): Boolean {
        return candidate.widget::class.simpleName == type
    }
}

class TextFinder(val text: String) : MatchFinder() {
    override fun matches(candidate: Element): Boolean {
        val widget: Widget = candidate.widget
        if (widget is Text) {
            return widget.text == text
        }
        return false
    }
}

abstract class MatchFinder : Finder() {
    abstract fun matches(candidate: Element): Boolean

    override fun apply(candidates: List<Element>): List<Element> {
        return candidates.toMutableList().filter { matches(it) }
    }
}

abstract class Finder {
    protected val allCandidates: List<Element>
        get() = this.collectAllElementsFrom(rootElement)


    private fun collectAllElementsFrom(rootElement: Element): List<Element> {
        val children = mutableListOf<Element>()
        rootElement.visitChildren(children::add)
        return children
    }

    abstract fun apply(candidates: List<Element>): List<Element>

    fun evaluate(): List<Element> {
        return apply(this.allCandidates)
    }
}