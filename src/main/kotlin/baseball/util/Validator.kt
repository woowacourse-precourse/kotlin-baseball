package baseball.util

object Validator {
    fun check3digitNum(num: String) {
        var number = num.toMutableList()

        // 3자리 수가 아닌 경우 예외 처리
        if (num.length != 3) {
            throw IllegalArgumentException("3자리 숫자를 입력해주세요.")
        }
        // 숫자 형태가 아닌 경우 예외 처리
        if (num.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자 형태로 입력해주세요.")
        }
        // 중복된 숫자가 있는 경우 예외 처리
        while (number.size != 0) {
            var first = number.removeFirst()
            if (first in number) {
                throw IllegalArgumentException("중복되지 않은 숫자를 입력해주세요.")
            }
        }
        // 1~9 사이 숫자가 아닌 경우 예외 처리
        for (i in num) {
            if ('0' in num) {
                throw IllegalArgumentException("1~9 사이 숫자를 입력해주세요.")
            }
        }
    }

    fun checkCommand(command: String) {
        if (command.length != 1) {
            throw IllegalArgumentException("1 또는 2를 입력해주세요.")
        }
        if (command !in "1,2") {
            throw IllegalArgumentException("1 또는 2를 입력해주세요.")
        }
    }
}