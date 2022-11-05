package utils

object ExceptionHandler {
    fun validateLengthOrException(answer: String, expectedLength: Int) {
        if (answer.length != expectedLength) throw IllegalArgumentException(Constants.LENGTH_MISMATCH_EXCEPTION)
    }

    fun <E> validateListLengthOrException(list: List<E>, expectedLength: Int) {
        if (list.size != expectedLength) throw IllegalArgumentException(Constants.LENGTH_MISMATCH_EXCEPTION)
    }

    fun validateDigitOrException(ch: Char): Int {
        val digit = ch.digitToIntOrNull() ?: throw IllegalArgumentException(Constants.NON_DIGIT_EXCEPTION)
        validateRangeOrException(digit)

        return digit
    }

    fun validateRangeOrException(digit: Int) {
        if (digit !in Constants.MIN_DIGIT..Constants.MAX_DIGIT) throw IllegalArgumentException(Constants.OUT_OF_RANGE_EXCEPTION)
    }

    fun validateDuplicatedOrException(inputs: Set<Int>) {
        if (inputs.size != Constants.DIGIT_LENGTH) throw IllegalArgumentException(Constants.DUPLICATED_DIGIT_EXCEPTION)
    }

    fun validateRestartCode(code: String) {
        validateLengthOrException(code, Constants.RESTART_LENGTH)
        validateRestartCodeCategory(code)
    }

    fun validateRestartCodeCategory(code: String) {
        if (code != Constants.YES_RESTART && code != Constants.NO_RESTART) throw IllegalArgumentException(Constants.WRONG_FORMAT_EXCEPTION)
    }
}