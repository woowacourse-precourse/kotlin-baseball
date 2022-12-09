package baseball.view.io

import baseball.view.validate.InputValidate
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputValidate: InputValidate = InputValidate()

    fun inputBaseballNumbers(): List<Int> {
        val inputBaseballNumbers = Console.readLine()
        inputValidate.baseballNumbersForm(inputBaseballNumbers)
        inputValidate.duplicateBaseballNumbers(inputBaseballNumbers)
        return inputBaseballNumbers.toList().map { number -> number.digitToInt() }
    }

    fun inputRestartNumber(): Int {
        val inputRestartNumber = Console.readLine()
        inputValidate.restartNumber(inputRestartNumber)
        return inputRestartNumber.first().digitToInt()
    }

}