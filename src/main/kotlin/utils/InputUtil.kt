package utils

import camp.nextstep.edu.missionutils.Console
import domain.Player

object InputUtil {
    fun enterAnswer(): Player {
        print("숫자를 입력해주세요 : ")

        val playerInput = Console.readLine()
        validateLengthOrException(playerInput)

        val answers = linkedSetOf<Int>()
        playerInput.forEach { ch ->
            val digit = validateDigitOrException(ch)
            answers.add(digit)
        }

        validateDuplicatedOrException(answers)

        return Player(answers.toList())
    }

    private fun validateLengthOrException(answer: String) {
        if (answer.length != 3) throw IllegalArgumentException("입력값의 길이가 3이 아닙니다.")
    }

    private fun validateDigitOrException(ch: Char): Int {
        val digit = ch.digitToIntOrNull() ?: throw IllegalArgumentException("입력값이 숫자가 아닙니다.")
        validateRangeOrException(digit)

        return digit
    }

    private fun validateRangeOrException(digit: Int) {
        if (digit !in 1 until 10) throw IllegalArgumentException("입력값이 올바른 범위가 아닙니다.")
    }

    private fun validateDuplicatedOrException(inputs: Set<Int>) {
        if (inputs.size != 3) throw IllegalArgumentException("중복된 숫자가 존재합니다.")
    }

}