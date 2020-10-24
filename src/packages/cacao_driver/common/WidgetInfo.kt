package packages.cacao_driver.common

public class WidgetInfo(public val info: Map<String, String>) : Result() {
    public companion object {
        public fun fromJson(json: Map<String, Any>): WidgetInfo {
            return WidgetInfo(json["widget"] as Map<String, String>)
        }
    }

    override fun toJson(): Map<String, Any> = mapOf("widget" to info)
}