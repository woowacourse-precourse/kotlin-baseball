package baseball.utils

import baseball.utils.Constant.ACTIVE_STATE_CODE
import baseball.utils.Constant.CNT_NUMBER
import baseball.utils.Constant.MIN_NUMBER
import baseball.utils.Constant.QUIT_STATE_CODE

object Validator {
    fun isValidAnswerNumber(input: String): Boolean {
        return input.isNotException(ExceptionType.GameException) && input.isNotDuplicated()
    }

    fun isValidExitCode(input: String): Boolean {
        return input.isNotException(ExceptionType.RetryException)
    }
}
private fun String.isNotDuplicated(): Boolean {
    val setOfUserInput = mutableSetOf<Int>()
    this.map { it.digitToInt() }.forEach {
        setOfUserInput.add(it)
    }
    return setOfUserInput.size == CNT_NUMBER
}

private fun String.isNotException(
    exceptionType: ExceptionType
): Boolean {
    return when (exceptionType) {
        is ExceptionType.GameException -> {
            if (this.isEmpty() || this.length > CNT_NUMBER) {
                false
            } else this.all { Character.isDigit(it) } && this.length == CNT_NUMBER
        }

        is ExceptionType.RetryException -> {
            if (this.isEmpty() || this.length > MIN_NUMBER) {
                false
            } else this.all { Character.isDigit(it) } && this.length == MIN_NUMBER && (this == ACTIVE_STATE_CODE || this == QUIT_STATE_CODE)
        }
    }
}

