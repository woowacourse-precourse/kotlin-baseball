package baseball.view

import baseball.utils.Validator
import baseball.view.Printer.printGuidelinePhrase
import baseball.view.Printer.printRetryPhrase
import camp.nextstep.edu.missionutils.Console

class Player(
    private val validator: Validator
) {

    fun inputAnswerNumber(): String {
        printGuidelinePhrase()
        val input: String = Console.readLine()
        require(validator.isValidAnswerNumber(input))
        return input
    }

    fun inputExitCode(): String {
        printRetryPhrase()
        val input: String = Console.readLine()
        require(validator.isValidExitCode(input))
        return input
    }
}