package baseball.util

import baseball.util.Constant.COMMAND
import baseball.util.Constant.ERROR_3DIGIT
import baseball.util.Constant.ERROR_COMMAND
import baseball.util.Constant.ERROR_DISTINCT
import baseball.util.Constant.ERROR_NUMBER
import baseball.util.Constant.ERROR_RANGE
import baseball.util.Constant.ZERO

object Validator {
    fun check3digitNum(num: String) {
        var number = num.toMutableList()

        // 3자리 수가 아닌 경우 예외 처리
        if (num.length != 3) {
            throw IllegalArgumentException(ERROR_3DIGIT)
        }
        // 숫자 형태가 아닌 경우 예외 처리
        if (num.toIntOrNull() == null) {
            throw IllegalArgumentException(ERROR_NUMBER)
        }
        // 중복된 숫자가 있는 경우 예외 처리
        while (number.size != 0) {
            var first = number.removeFirst()
            if (first in number) {
                throw IllegalArgumentException(ERROR_DISTINCT)
            }
        }
        // 1~9 사이 숫자가 아닌 경우 예외 처리
        for (i in num) {
            if (ZERO in num) {
                throw IllegalArgumentException(ERROR_RANGE)
            }
        }
    }

    fun checkCommand(command: String) {
        if (command !in COMMAND) {
            throw IllegalArgumentException(ERROR_COMMAND)
        }
    }
}