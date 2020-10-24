package packages.cacao.painting

public class Color(public val red: Int, public val green: Int, public val blue: Int, public val alpha: Int) {
    init {
        if (red > 255 || green > 255 || blue > 255 || alpha > 255)
            throw IllegalArgumentException("Value cannot be greater than 255")
        if (red < 0 || green < 0 || blue < 0 || alpha < 0)
            throw IllegalArgumentException("Value cannot be less than 0")
    }
}

public fun Color(hexColor: String): Color {
    return createColorUsingHex(hexColor)
}

private fun createColorUsingHex(hexColor: String): Color {
    if (!isValidHexColor(hexColor))
        throw IllegalArgumentException("Value must be hex format: #RRGGBB or #RRGGBBAA")

    val redPart = hexColor.substring(1, 3)
    val red = convertHexToInt(redPart)

    val greenPart = hexColor.substring(3, 5)
    val green = convertHexToInt(greenPart)

    val bluePart = hexColor.substring(5, 7)
    val blue = convertHexToInt(bluePart)

    val alphaPart = if (hexColor.length == 9) hexColor.substring(7, 9) else "ff"
    val alpha = convertHexToInt(alphaPart)

    return Color(red, green, blue, alpha)
}

private fun isValidHexColor(hexString: String): Boolean {
    return hexString.startsWith('#') &&
        isValidLength(hexString) &&
        areValidHexValues(hexString.substring(1))
}

private fun isValidLength(hexString: String): Boolean {
    return hexString.length == 7 || hexString.length == 9
}

private fun areValidHexValues(hexValues: String): Boolean {
    return hexValues.all(::isValidHexValue)
}

private fun isValidHexValue(c: Char): Boolean {
    return convertHexCharToDecimal(c) < 16
}

private fun convertHexCharToDecimal(c: Char): Int {
    return c.toString().toInt(16)
}

private fun convertHexToInt(hexNumber: String): Int {
    return hexNumber.toInt(16)
}