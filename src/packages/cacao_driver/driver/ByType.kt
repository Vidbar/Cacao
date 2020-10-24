package packages.cacao_driver.driver

public class ByType(public val type: String) : SerializableFinder() {
    override val finderType: String = "byType"
    override fun serialize(): Map<String, String> = super.serialize() + ("type" to type)

    public companion object {
        public fun deserialize(json: Map<String, String>): ByType {
            return ByType(json["type"] ?: error("!"))
        }
    }
}
