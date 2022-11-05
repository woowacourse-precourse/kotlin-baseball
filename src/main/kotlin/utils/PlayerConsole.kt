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
import utils.Constants.NO_RESTART
import utils.Constants.OUT_OF_RANGE_EXCEPTION
import utils.Constants.RESTART_ASKING_TEXT
import utils.Constants.RESTART_LENGTH
import utils.Constants.WRONG_FORMAT_EXCEPTION
import utils.Constants.YES_RESTART

object PlayerConsole {
    fun enterAnswer(): Player {
        print(ENTER_NUMBER_TEXT)

        val playerInput = Console.readLine()
        validateLengthOrException(playerInput, DIGIT_LENGTH)

        val answers = linkedSetOf<Int>()
        playerInput.forEach { ch ->
            val digit = validateDigitOrException(ch)
            answers.add(digit)
        }

        validateDuplicatedOrException(answers)

        return Player(answers.toList())
    }

    fun enterRestart(): String {
        println(RESTART_ASKING_TEXT)

        val restartCode = Console.readLine()
        restartCode
        validateRestartCode(restartCode)

        return restartCode
    }

    private fun validateLengthOrException(answer: String, expectedLength: Int) {
        if (answer.length != expectedLength) throw IllegalArgumentException(LENGTH_MISMATCH_EXCEPTION)
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

    private fun validateRestartCode(code: String) {
        validateLengthOrException(code, RESTART_LENGTH)
        validateIsRestartCode(code)
    }

    private fun validateIsRestartCode(code: String) {
        if (code != YES_RESTART && code != NO_RESTART) throw IllegalArgumentException(WRONG_FORMAT_EXCEPTION)
    }
}