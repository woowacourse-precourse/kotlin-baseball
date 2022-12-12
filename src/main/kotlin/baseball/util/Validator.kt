package baseball.util

object Validator {
    fun check3digitNum(num: String): Boolean {
        // 숫자 형태가 아닌 경우 예외 처리
        if (num.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자 형태로 입력해주세요.")
        }
        // 1~9 사이 숫자가 아닌 경우 예외 처리
        for (i in num) {
            if (i !in '1'..'9') {
                throw IllegalArgumentException("1~9 사이 숫자를 입력해주세요.")
            }
        }
        // 3자리 수가 아닌 경우 또는 중복된 숫자가 있는 경우 예외 처리
        if (setOf(num.toList()).size != 3) {
            throw IllegalArgumentException("중복되지 않은 3자리 숫자를 입력해주세요.")
        }
        return true
    }
}