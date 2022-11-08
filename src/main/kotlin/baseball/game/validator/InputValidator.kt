package baseball.game.validator

import baseball.common.MAX_NUMBER_SIZE
import baseball.game.END_CODE
import baseball.game.RESTART_CODE

object InputValidator {

    /** 사용자가 입력한 숫자야구 값을 검증하는 함수 **/
    fun validateGameInput(input: String) {
        (isDigit(input = input) && isCorrectLength(input = input) && isNoDuplicate(input = input)).let { isCorrectInput ->
            if (!isCorrectInput) throw java.lang.IllegalArgumentException()
        }
    }

    /** 사용자가 입력한 게임 종료 여부 값을 검증하는 함수 **/
    fun validateEndInput(input: String) {
        (isDigit(input = input) && isCorrectRange(input = input)).let { isCorrectInput ->
            if(!isCorrectInput) throw java.lang.IllegalArgumentException()
        }
    }

    // TODO string에 대한 확장함수로 빼기
    private fun isDigit(input: String): Boolean =
        input.all { eachChar -> eachChar.isDigit() && eachChar.code != 48 }

    private fun isCorrectLength(input: String): Boolean =
        input.length == MAX_NUMBER_SIZE

    private fun isNoDuplicate(input: String): Boolean =
        input.toSet().size == MAX_NUMBER_SIZE

    private fun isCorrectRange(input: String): Boolean =
        input.toInt() in RESTART_CODE..END_CODE
}
