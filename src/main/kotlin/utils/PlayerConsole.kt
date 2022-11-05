package utils

import camp.nextstep.edu.missionutils.Console
import domain.Player
import utils.Constants.DIGIT_LENGTH
import utils.Constants.ENTER_NUMBER_TEXT
import utils.Constants.RESTART_ASKING_TEXT
import utils.ExceptionHandler.validateDigitOrException
import utils.ExceptionHandler.validateDuplicatedOrException
import utils.ExceptionHandler.validateLengthOrException
import utils.ExceptionHandler.validateRestartCode

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
        validateRestartCode(restartCode)

        return restartCode
    }
}