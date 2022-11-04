package baseball

class Exception {
    companion object {
        const val NUMBER_OF_DIGITS = 3
        const val ASCII_CODE_ONE = 48
        const val ASCII_CODE_NINE = 57
        const val RESTART = 1
        const val END = 2
    }

    fun throwThreeLetterException(input: List<Char>) {
        if (input.size != NUMBER_OF_DIGITS) {
            throw IllegalArgumentException("3개의 숫자를 입력하세요")
        }
    }

    fun throwNonNaturalNumberException(input: List<Char>) {
        input.forEach { char ->
            if (char.code < ASCII_CODE_ONE || char.code > ASCII_CODE_NINE) {
                throw IllegalArgumentException("숫자만 입력하세요")
            }
        }
    }

    fun throwDuplicateNumberException(input: List<Char>) {
        if (input.distinct() != input) {
            throw IllegalArgumentException("서로 다른수를 입력해주세요")
        }
    }

    fun checkAllException(input: List<Char>) {
        throwThreeLetterException(input)
        throwNonNumberException(input)
        throwDuplicateNumberException(input)
    }

    fun throwInvalidRestartNumber(input: String) {
        if (!(input == "$RESTART" || input == "$END")) {
            throw java.lang.IllegalArgumentException("1,2 중 하나를 입력해주세요")
        }
    }
}