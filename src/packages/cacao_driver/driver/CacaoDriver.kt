package packages.cacao_driver.driver

import packages.cacao_driver.common.Command
import packages.cacao_driver.common.GetWidget
import packages.cacao_driver.common.WidgetInfo
import packages.cacao_driver.extension.DriverExtension

class CacaoDriver {
    lateinit var driverExtension: DriverExtension
    fun connect(driverExtension: DriverExtension) {
        //TODO(remove the driverExtension and add support to send/receive command via ws)
        this.driverExtension = driverExtension
    }

    fun sendCommand(command: Command): Map<String, Any> {
        val serialized = command.serialize()
        val response = this.driverExtension.call(serialized)
        return response
    }

    fun getWidget(finder: SerializableFinder): WidgetInfo {
        return WidgetInfo.fromJson(this.sendCommand(GetWidget(finder)))
    }
}
