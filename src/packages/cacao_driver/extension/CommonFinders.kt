package packages.cacao_driver.extension

val find = CommonFinders()

class CommonFinders {
    fun widgetType(type: String): Finder = WidgetTypeFinder(type)
}