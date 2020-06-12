package packages.cacao_driver.common

import packages.cacao_driver.driver.SerializableFinder

class GetWidget(val finder: SerializableFinder) : Command() {
    override val kind: String = "getWidget"

    override fun serialize(): Map<String, String> = super.serialize().toMutableMap() + finder.serialize()

    companion object{
        fun deserialize(json: Map<String, String>): GetWidget{
            return GetWidget(SerializableFinder.deserialize(json))
        }
    }
}