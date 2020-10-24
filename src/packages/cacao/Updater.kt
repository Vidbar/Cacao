package packages.cacao

public typealias UpdateCallback = () -> Unit

public class Updater private constructor() {
    public companion object {
        public val updater: Updater = Updater()
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

    public fun setDrawUpdate(update: UpdateCallback) {
        this.drawUpdate = update
    }

    public fun enqueueUpdate() {
        this.drawUpdate?.let { this.pushUpdate(it) }
    }

    public fun resolveUpdates() {
        while (this.hasUpdatesPending()) {
            val update = this.popUpdate()
            update()
        }
    }
}
