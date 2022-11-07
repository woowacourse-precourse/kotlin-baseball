package baseball.game

object ExceptionHandler {

    fun checkNumberFormat(number: String): String {
        if (number.length != 3)
            throw IllegalArgumentException("number=$number, 3자리 숫자여야 합니다.")
        if (number.toSet().size != 3)
            throw IllegalArgumentException("number=$number, 중복된 숫자가 있으면 안 됩니다.")
        if (number.any { it !in '1'..'9' })
            throw IllegalArgumentException("number=$number, 각 자리의 숫자는 (1 ~ 9) 사이의 숫자여야 합니다.")

        return number
    }

    fun throwFinishCode(code: String): Nothing {
        TODO()
    }
}