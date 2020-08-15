package packages.cacao

typealias UpdateCallback = () -> Unit

class Updater private constructor() {
    companion object {
        val updater = Updater()
    }

    private val updates = mutableListOf<UpdateCallback>()
    private var drawUpdate: UpdateCallback? = null

    private fun pushUpdate(update: UpdateCallback) {
        this.updates.add(update)
    }

    private fun popUpdate(): UpdateCallback {
        return this.updates.removeAt(0)
    }

    private fun hasUpdatesPending(): Boolean {
        return this.updates.isNotEmpty()
    }

    fun setDrawUpdate(update: UpdateCallback) {
        this.drawUpdate = update
    }

    fun enqueueUpdate() {
        this.drawUpdate?.let { this.pushUpdate(it) }
    }

    fun resolveUpdates() {
        while (this.hasUpdatesPending()) {
            val update = this.popUpdate()
            update()
        }
    }
}