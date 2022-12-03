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
}