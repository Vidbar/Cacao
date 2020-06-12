package packages.cacao_driver.driver

val by = CommonSerializableFinders()

class CommonSerializableFinders {
    fun type(type: String): SerializableFinder = ByType(type)
}