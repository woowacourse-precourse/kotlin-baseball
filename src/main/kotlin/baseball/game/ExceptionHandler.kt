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

    fun isRestartCode(code: String): Boolean {
        if (code != Message.RESTART_CODE && code != Message.FINISH_CODE)
            throw IllegalArgumentException("code=$code, 코드를 잘못 입력하셨습니다.")

        return code == Message.RESTART_CODE
    }
}