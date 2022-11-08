package baseball

class Exception {
    fun isInvalidBaseballNumber(userNumber: String) {
        val regex = Regex("^[0-9]{3}\$")

        if (!regex.matches(userNumber))
            throw IllegalArgumentException("유효한 3자리 숫자가 아닙니다.")

        if (userNumber.toList().count() != userNumber.toSet().count()) {
            throw IllegalArgumentException("서로 다른 3자리 숫자가 아닙니다.")
        }
    }

    fun isInvalidTrigger(trigger: String) {
        val regex = Regex("^[1-2]\$")

        if (!regex.matches(trigger))
            throw IllegalArgumentException("1 또는 2가 아닙니다.")
    }
}