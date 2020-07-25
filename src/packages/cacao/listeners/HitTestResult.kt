package packages.cacao.listeners

class HitTestResult {
    private val path: MutableList<IHitTestTarget> = mutableListOf()
    fun add(entry: IHitTestTarget) {
        this.path.add(entry)
    }
}
