package baseball.view.validator

import baseball.util.ERROR_INVALID_INPUT_MESSAGE
import baseball.util.MAX_SIZE

object InputValidator {
    fun validateUserInput(input: String) {
        if (input.length > MAX_SIZE) throw IllegalArgumentException(ERROR_INVALID_INPUT_MESSAGE)
    }
}