package utils

import camp.nextstep.edu.missionutils.Console
import domain.Player
import utils.Constants.DIGIT_LENGTH
import utils.Constants.DUPLICATED_DIGIT_EXCEPTION
import utils.Constants.ENTER_NUMBER_TEXT
import utils.Constants.LENGTH_MISMATCH_EXCEPTION
import utils.Constants.MAX_DIGIT
import utils.Constants.MIN_DIGIT
import utils.Constants.NON_DIGIT_EXCEPTION
import utils.Constants.OUT_OF_RANGE_EXCEPTION

object InputUtil {
    fun enterAnswer(): Player {
        print(ENTER_NUMBER_TEXT)

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
        if (answer.length != DIGIT_LENGTH) throw IllegalArgumentException(LENGTH_MISMATCH_EXCEPTION)
    }

    private fun validateDigitOrException(ch: Char): Int {
        val digit = ch.digitToIntOrNull() ?: throw IllegalArgumentException(NON_DIGIT_EXCEPTION)
        validateRangeOrException(digit)

        return digit
    }

    private fun validateRangeOrException(digit: Int) {
        if (digit !in MIN_DIGIT..MAX_DIGIT) throw IllegalArgumentException(OUT_OF_RANGE_EXCEPTION)
    }

    private fun validateDuplicatedOrException(inputs: Set<Int>) {
        if (inputs.size != DIGIT_LENGTH) throw IllegalArgumentException(DUPLICATED_DIGIT_EXCEPTION)
    }

}