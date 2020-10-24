package packages.cacao_driver.driver

public abstract class SerializableFinder {
    public abstract val finderType: String
    public open fun serialize(): Map<String, String> = mapOf("finderType" to finderType)

    public companion object {
        public fun deserialize(json: Map<String, String>): SerializableFinder {
            when (json["finderType"] as String) {
                "byType" -> return ByType.deserialize(json)
                else -> error("!")
            }
        }
    }
}