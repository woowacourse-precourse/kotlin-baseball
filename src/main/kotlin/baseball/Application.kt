package baseball

import java.util.*

fun main() {

}

private fun validateInputString(inputString: String, isNewGameCheckInputString: Boolean) {
    if (isNewGameCheckInputString && isContinuedNewGameCheckInputError(inputString))
        throw IllegalArgumentException("User New Game Continue Check Input Error")

    if (!isNewGameCheckInputString && isPredictionInputError(inputString))
        throw IllegalArgumentException("User Prediction Input Error")
}

private fun isContinuedNewGameCheckInputError(inputString: String): Boolean {
    if (isNotInteger(inputString))
        return true

    if (inputString == "1" || inputString == "2")
        return false

    return true
}

private fun isPredictionInputError(inputString: String): Boolean {
    if (isNotInteger(inputString))
        return true
    if (containsZeroDigit(inputString))
        return true
    if (inputString.length != 3)
        return true

    val numberCheckList: MutableList<Boolean> = ArrayList(Collections.nCopies(10, false))
    for (currentDigit in inputString) {
        if (numberCheckList[currentDigit.code - '0'.code])
            return true

        numberCheckList[currentDigit.code - '0'.code] = true
    }
    return false
}

private fun isNotInteger(string: String): Boolean {
    return try {
        string.toInt()
        false
    } catch (e: NumberFormatException) {
        true
    }
}

private fun containsZeroDigit(string: String): Boolean = string.contains("0")