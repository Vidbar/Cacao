package packages.cacao_driver.driver

public val by: CommonSerializableFinders = CommonSerializableFinders()

public class CommonSerializableFinders {
    public fun type(type: String): SerializableFinder = ByType(type)
}