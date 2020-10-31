package unitTest

import org.junit.*
import packages.cacao.painting.*
import kotlin.test.*

class StyleTest {
    @Test
    fun `New style, should have default black color`() {
        val expectedColor = Color("#000000")
        val style = Style()

        assertEquals(expectedColor, style.color)
    }
}