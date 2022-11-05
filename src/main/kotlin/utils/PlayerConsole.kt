package utils

import camp.nextstep.edu.missionutils.Console
import model.Player
import utils.Constants.ENTER_NUMBER_TEXT
import utils.Constants.RESTART_ASKING_TEXT
import utils.ExceptionHandler.validateDigitOrException
import utils.ExceptionHandler.validateRestartCode

object PlayerConsole {
    fun enterAnswer(): Player {
        print(ENTER_NUMBER_TEXT)

        val answers = arrayListOf<Int>()
        val playerInput = Console.readLine()

        playerInput.forEach { ch ->
            val digit = validateDigitOrException(ch)
            answers.add(digit)
        }

        return Player(answers)
    }

    fun enterRestart(): String {
        println(RESTART_ASKING_TEXT)

        val restartCode = Console.readLine()
        validateRestartCode(restartCode)

        return restartCode
    }
}