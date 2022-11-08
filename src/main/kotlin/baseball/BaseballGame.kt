package baseball

import baseball.BaseballSetting.*
import camp.nextstep.edu.missionutils.Console

class BaseballGame(var computerNumbers: ComputerNumbers) {
    fun start() {
        var processStatus = START_OR_RESTART.number
        BaseballString.START.print()
        while (processStatus == START_OR_RESTART.number) {
            BaseballString.INPUT.print()
            val userInput = Console.readLine()
            checkValidInput(userInput)
            var result = getResult(userInput)
            processStatus = processByResult(result)
        }
        BaseballString.QUIT.print()
    }

    private fun processByResult(result: Int): Int {
        return when (result) {
            DIGIT_NUMBER.number -> {
                BaseballString.SUCCESS.print()
                decideRestartOrQuit()
            }
            else -> START_OR_RESTART.number
        }
    }

    private fun decideRestartOrQuit(): Int {
        BaseballString.RESTART_OR_QUIT.print()
        return when (val userInput = Console.readLine().toInt()) {
            QUIT.number -> userInput
            START_OR_RESTART.number -> {
                resetComputerNumbers()
                userInput
            }
            else -> throw IllegalArgumentException()
        }
    }

    private fun getResult(userInput: String): Int {
        val baseballResult = computerNumbers.compareToUserInput(userInput)
        println(baseballResult)
        return baseballResult.strike
    }

    private fun checkValidInput(userInput: String) {
        if (userInput.length != DIGIT_NUMBER.number ||
            !userInput.isNumberString()
        ) {
            throw IllegalArgumentException()
        }
    }

    fun String.isNumberString() = this.all { it.isDigit() }

    private fun resetComputerNumbers() {
        computerNumbers =
            ComputerNumbers(RandomNumberGenerator.nDigitMap(DIGIT_NUMBER.number))
    }
}