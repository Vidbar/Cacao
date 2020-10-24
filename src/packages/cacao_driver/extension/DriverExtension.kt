package packages.cacao_driver.extension

import packages.cacao.widgets.basicWidgets.Text
import packages.cacao_driver.common.Command
import packages.cacao_driver.common.GetWidget
import packages.cacao_driver.common.Result
import packages.cacao_driver.common.WidgetInfo
import packages.cacao_driver.driver.ByType
import packages.cacao_driver.driver.SerializableFinder

public typealias CommandHandlerCallback = (Command) -> Result
public typealias CommandDeserializerCallback = (Map<String, String>) -> Command
public typealias FinderConstructor = (SerializableFinder) -> Finder

public class DriverExtension {
    private val commandHandlers: Map<String, CommandHandlerCallback> = mapOf(
        "getWidget" to this::getWidget
    )

    private val commandDeserializers: Map<String, CommandDeserializerCallback> = mapOf(
        "getWidget" to { params -> GetWidget.deserialize(params) }
    )

    private val finders: Map<String, FinderConstructor> = mapOf(
        "byType" to { finder -> createByTypeFinder(finder as ByType) }
    )

    private fun createByTypeFinder(byType: ByType): Finder {
        return find.widgetType(byType.type)
    }

    private fun getWidget(command: Command): Result {
        val getWidgetCommand = command as GetWidget
        val finder: Finder = createFinder(getWidgetCommand.finder)
        val widget = finder.evaluate().first().widget as Text
        return WidgetInfo(mapOf("text" to widget.text))
    }

    private fun createFinder(finder: SerializableFinder): Finder {
        val finderConstructor = this.finders[finder.finderType]
        return if (finderConstructor != null) {
            finderConstructor(finder)
        } else {
            throw error("Unsupported finder type:${finder.finderType}")
        }
    }

    public fun call(params: Map<String, String>): Map<String, Any> {
        val commandKind = params["command"]
        try {
            val commandHandler = this.commandHandlers[commandKind]
            val commandDeserializer = this.commandDeserializers[commandKind]
            val command = (commandDeserializer!!)(params)
            val response: Result = (commandHandler!!)(command)
            return response.toJson()
        } catch (error: Exception) {
            throw error("!")
        }
    }
}