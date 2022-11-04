package baseball.validator

import baseball.common.MAX_NUMBER_SIZE


class InputValidator {
    fun checkCorrectInput(input: String) {

    }

    fun isDigit(input: String): Boolean {
        return input.all {
            it.isDigit()
            it.code != 48
        }
    }

    fun isCorrectLength(input: String): Boolean =
        input.length == MAX_NUMBER_SIZE




}
