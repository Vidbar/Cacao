package packages.cacao_driver.common

class WidgetInfo(val info: Map<String, String>) : Result(){
    companion object {
        fun fromJson(json: Map<String, Any>): WidgetInfo {
            return WidgetInfo(json["widget"] as Map<String, String>)
        }
    }

    override fun toJson(): Map<String, Any> = mapOf("widget" to info)
}