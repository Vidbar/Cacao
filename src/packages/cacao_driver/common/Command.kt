package packages.cacao_driver.common

abstract class Command {
    abstract val kind: String
    open fun serialize(): Map<String, String> {
        return mapOf("command" to kind)
    }
}

abstract class Result {
    abstract fun toJson(): Map<String, Any>
}
