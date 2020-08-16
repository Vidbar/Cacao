package packages.cacao

import packages.cacao.elements.Element

class BuildOwner {
    private val dirtyElements = mutableListOf<Element>()
    fun scheduleBuildFor(element: Element) {
        this.dirtyElements.add(element)
    }

    fun buildScope() {
        this.dirtyElements.forEach { it.rebuild() }
        this.dirtyElements.clear()
    }
}