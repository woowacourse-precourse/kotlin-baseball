package baseball

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputValidate: InputValidate = InputValidate()

    fun inputBaseballNumbers(): List<Int> {
        println("숫자를 입력해주세요 : ")
        val inputBaseballNumbers = Console.readLine()
        inputValidate.baseballNumbersForm(inputBaseballNumbers)
        inputValidate.duplicateBaseballNumbers(inputBaseballNumbers)
        return inputBaseballNumbers.toList().map { number -> number.digitToInt() }
    }

    fun inputRestartNumber(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val inputRestartNumber = Console.readLine()
        inputValidate.restartNumber(inputRestartNumber)
        return inputRestartNumber.first().digitToInt()
    }

}