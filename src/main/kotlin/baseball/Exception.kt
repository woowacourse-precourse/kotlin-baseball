package baseball

class Exception {
    fun throwThreeLetterException(input: List<Char>) {
        val numberOfDigits = 3
        if (input.size != numberOfDigits) {
            throw IllegalArgumentException("3개의 숫자를 입력하세요")
        }
    }

    fun throwNonNumberException(input: List<Char>) {
        val asciiCodeZero = 48
        val asciiCodeNine = 57
        input.forEach { char ->
            if (char.code < asciiCodeZero || char.code > asciiCodeNine) {
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
        if (!(input == "1" || input == "2")) {
            throw java.lang.IllegalArgumentException("1,2 중 하나를 입력해주세요")
        }
    }
}