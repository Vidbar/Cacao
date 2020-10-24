package packages.cacao_driver.common

public abstract class Command {
    public abstract val kind: String
    public open fun serialize(): Map<String, String> {
        return mapOf("command" to kind)
    }
}

public abstract class Result {
    public abstract fun toJson(): Map<String, Any>
}
