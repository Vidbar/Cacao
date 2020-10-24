package packages.cacao_driver.common

import packages.cacao_driver.driver.SerializableFinder

public class GetWidget(public val finder: SerializableFinder) : Command() {
    override val kind: String = "getWidget"

    override fun serialize(): Map<String, String> = super.serialize().toMutableMap() + finder.serialize()

    public companion object {
        public fun deserialize(json: Map<String, String>): GetWidget {
            return GetWidget(SerializableFinder.deserialize(json))
        }
    }
}