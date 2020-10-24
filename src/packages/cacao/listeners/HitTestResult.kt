package packages.cacao.listeners

import packages.cacao.renderObjects.RenderObject

public class HitTestResult {
    private val _path: MutableList<RenderObject> = mutableListOf()
    public val path: List<RenderObject>
        get() = this._path

    public fun add(entry: RenderObject) {
        this._path.add(entry)
    }
}
