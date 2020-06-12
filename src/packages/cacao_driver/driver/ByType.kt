package packages.cacao_driver.driver

class ByType(val type: String) : SerializableFinder() {
    override val finderType: String = "byType"
    override fun serialize(): Map<String, String> = super.serialize() + ("type" to type)

    companion object {
        fun deserialize(json: Map<String, String>): ByType {
            return ByType(json["type"] ?: error("!"))
        }
    }
}
