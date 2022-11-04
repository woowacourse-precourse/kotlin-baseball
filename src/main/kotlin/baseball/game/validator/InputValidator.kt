package baseball.game.validator

import baseball.common.MAX_NUMBER_SIZE


abstract class InputValidator {
    fun checkInputValid(input: String) {
        (isDigit(input = input) && isCorrectLength(input = input) && isNoDuplicate(input = input)).let { isCorrectInput ->
            if (!isCorrectInput)
                throw java.lang.IllegalArgumentException()
        }
    }

    private fun isDigit(input: String): Boolean {
        return input.all { eachChar ->
            eachChar.isDigit() && eachChar.code != 48
        }
    }

    private fun isCorrectLength(input: String): Boolean =
        input.length == MAX_NUMBER_SIZE

    private fun isNoDuplicate(input: String): Boolean =
        input.toSet().size == MAX_NUMBER_SIZE
}
