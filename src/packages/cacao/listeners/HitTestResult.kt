package packages.cacao.listeners

import packages.cacao.renderObjects.RenderObject

class HitTestResult {
    private val _path: MutableList<RenderObject> = mutableListOf()
    val path: List<RenderObject>
        get() = this._path

    fun add(entry: RenderObject) {
        this._path.add(entry)
    }
}
