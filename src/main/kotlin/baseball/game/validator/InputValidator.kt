package baseball.game.validator

import baseball.common.MAX_NUMBER_SIZE
import baseball.game.END_CODE
import baseball.game.RESTART_CODE

object InputValidator {

    /** 사용자가 입력한 숫자야구 값을 검증하는 함수 **/
    fun validateGameInput(input: String) {
        (input.isDigit() && input.isCorrectLength() && input.isNoDuplicate()).let { isCorrectInput ->
            if (!isCorrectInput) throw java.lang.IllegalArgumentException()
        }
    }

    /** 사용자가 입력한 게임 종료 여부 값을 검증하는 함수 **/
    fun validateEndInput(input: String) {
        (input.isDigit() && input.isCorrectRange()).let { isCorrectInput ->
            if (!isCorrectInput) throw java.lang.IllegalArgumentException()
        }
    }

    private fun String.isDigit(): Boolean =
        this.all { eachChar -> eachChar.isDigit() && eachChar.code != 48 }

    private fun String.isCorrectLength(): Boolean =
        this.length == MAX_NUMBER_SIZE

    private fun String.isNoDuplicate(): Boolean =
        this.toSet().size == MAX_NUMBER_SIZE

    private fun String.isCorrectRange(): Boolean =
        this.toInt() in RESTART_CODE..END_CODE
}
