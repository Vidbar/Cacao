package packages.cacao_driver.extension

public val find: CommonFinders = CommonFinders()

public class CommonFinders {
    public fun widgetType(type: String): Finder = WidgetTypeFinder(type)
}