package packages.cacao_driver.driver

abstract class SerializableFinder {
    abstract val finderType: String
    open fun serialize(): Map<String, String> = mapOf("finderType" to finderType)

    companion object {
        fun deserialize(json: Map<String, String>): SerializableFinder {
            return when (json["finderType"] as String) {
                "byType" -> return ByType.deserialize(json)
                else -> error("!")
            }
        }
    }
}