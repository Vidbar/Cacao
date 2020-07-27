package packages.cacao.listeners

class HitTestResult {
    private val _path: MutableList<IHitTestTarget> = mutableListOf()
    val path: List<IHitTestTarget>
        get() = this._path

    fun add(entry: IHitTestTarget) {
        this._path.add(entry)
    }
}
