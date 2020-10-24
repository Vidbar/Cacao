package packages.cacao

import packages.cacao.elements.Element

public class BuildOwner {
    private val dirtyElements = mutableListOf<Element>()
    public fun scheduleBuildFor(element: Element) {
        this.dirtyElements.add(element)
    }

    public fun buildScope() {
        this.dirtyElements.forEach { it.rebuild() }
        this.dirtyElements.clear()
    }
}
