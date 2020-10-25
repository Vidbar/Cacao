package unitTest

import org.junit.*
import packages.cacao.painting.*
import kotlin.test.*

class ColorTest {
    @Test
    fun `Given a string without # should throw error`() {
        val wrongString = "hola!"

        assertFailsWith<IllegalArgumentException>("Value must be hex format: #RRGGBB or #RRGGBBAA") {
            Color(wrongString)
        }
    }

    @Test
    fun `Given a string starting with # and length different of 7 should throw error`() {
        val wrongString = "#hola"

        assertFailsWith<IllegalArgumentException>("Value must be hex format: #RRGGBB or #RRGGBBAA") {
            Color(wrongString)
        }
    }

    @Test
    fun `Given a string starting with # and non-hexadecimal letters should throw error`() {
        val wrongString = "#rrggjj"

        assertFailsWith<IllegalArgumentException>("Value must be hex format: #RRGGBB or #RRGGBBAA") {
            Color(wrongString)
        }
    }

    @Test
    fun `Given a hex color with ff red should instance a Color with 255 red`() {
        val hexValue = "#ff0000"
        val expectedRed = 255
        val color = Color(hexValue)

        assertEquals(expectedRed, color.red)
    }

    @Test
    fun `Given a hex color with ff green should instance a Color with 255 green`() {
        val hexValue = "#ffff00"
        val expectedGreen = 255
        val color = Color(hexValue)

        assertEquals(expectedGreen, color.green)
    }

    @Test
    fun `Given a hex color with ff blue should instance a Color with 255 blue`() {
        val hexValue = "#ffffff"
        val expectedBlue = 255
        val color = Color(hexValue)

        assertEquals(expectedBlue, color.blue)
    }

    @Test
    fun `Given a hex color with 00 red should instance a Color with 0 red`() {
        val hexValue = "#000000"
        val expectedRed = 0
        val color = Color(hexValue)

        assertEquals(expectedRed, color.red)
    }

    @Test
    fun `Given a hex color with 00 green should instance a Color with 0 green`() {
        val hexValue = "#000000"
        val expectedGreen = 0
        val color = Color(hexValue)

        assertEquals(expectedGreen, color.green)
    }

    @Test
    fun `Given a hex color with 00 blue should instance a Color with 0 blue`() {
        val hexValue = "#000000"
        val expectedBlue = 0
        val color = Color(hexValue)

        assertEquals(expectedBlue, color.blue)
    }

    @Test
    fun `Given a hex color with ff alpha should instance a Color with 255 alpha`() {
        val hexValue = "#000000ff"
        val expectedAlpha = 255
        val color = Color(hexValue)

        assertEquals(expectedAlpha, color.alpha)
    }

    @Test
    fun `Given a hex color with 00 alpha should instance a Color with 0 alpha`() {
        val hexValue = "#00000000"
        val expectedAlpha = 0
        val color = Color(hexValue)

        assertEquals(expectedAlpha, color.alpha)
    }

    @Test
    fun `Given a hex color with length 7 should instance a Color with 255 alpha`() {
        val hexValue = "#000000"
        val expectedAlpha = 255
        val color = Color(hexValue)

        assertEquals(expectedAlpha, color.alpha)
    }

    @Test
    fun `Given a hex color with 88 88 88 88 alpha should instance a Color with 136 136 136 136`() {
        val hexValue = "#88888888"
        val expectedDecimal = 136
        val color = Color(hexValue)

        assertEquals(expectedDecimal, color.red)
        assertEquals(expectedDecimal, color.green)
        assertEquals(expectedDecimal, color.blue)
        assertEquals(expectedDecimal, color.alpha)
    }

    @Test
    fun `Given a number greater than 255 should throw error`() {
        assertFailsWith<IllegalArgumentException>("Value cannot be greater than 255") {
            Color(256, 256, 256, 256)
        }
    }

    @Test
    fun `Given a number less than 0 should throw error`() {
        assertFailsWith<IllegalArgumentException>("Value cannot be less than 0") {
            Color(-1, -1, -1, -1)
        }
    }

    @Test
    fun `Two Color instances with the same color, should return that they are the same`() {
        val hexColor = "#01f3a9"
        val color1 = Color(hexColor)
        val color2 = Color(hexColor)

        val areTheSame = color1 == color2

        assertTrue(areTheSame)
    }

    @Test
    fun `Two Color instances with different red, should return that they are different`() {
        val color1 = Color("#110000")
        val color2 = Color("#220000")

        val areTheSame = color1 == color2

        assertFalse(areTheSame)
    }

    @Test
    fun `Two Color instances with different green, should return that they are different`() {
        val color1 = Color("#001100")
        val color2 = Color("#002200")

        val areTheSame = color1 == color2

        assertFalse(areTheSame)
    }

    @Test
    fun `Two Color instances with different blue, should return that they are different`() {
        val color1 = Color("#000011")
        val color2 = Color("#000022")

        val areTheSame = color1 == color2

        assertFalse(areTheSame)
    }

    @Test
    fun `Two Color instances with different alphas, should return that they are different`() {
        val color1 = Color("#00000011")
        val color2 = Color("#00000022")

        val areTheSame = color1 == color2

        assertFalse(areTheSame)
    }
}