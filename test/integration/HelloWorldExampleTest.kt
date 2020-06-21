package integration

import examples.helloWorld.main
import org.junit.Test
import packages.cacao.graphic.changeGraphicAdapter
import packages.cacao.widgets.Text
import packages.cacao_driver.driver.CacaoDriver
import packages.cacao_driver.driver.by
import packages.cacao_driver.extension.DriverExtension
import kotlin.test.assertEquals

class HelloWorldExampleTest {
    private val driverExtension = DriverExtension()
    val application = ::main

    private val byType = by.type(Text::class.simpleName!!)
    private val driver: CacaoDriver = CacaoDriver()

    @Test
    fun `Get the label text`() {
        changeGraphicAdapter { TestGraphicAdapter() }
        this.application()
        driver.connect(this.driverExtension)
        val first = driver.getWidget(this.byType)
        assertEquals("Hello, World!", first.info["text"])
    }
}