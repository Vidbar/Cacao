package packages.cacao.listeners

class HitTestResult {
    private val path: MutableList<ITestTarget> = mutableListOf()
    fun add(entry: ITestTarget) {
        this.path.add(entry)
    }
}
