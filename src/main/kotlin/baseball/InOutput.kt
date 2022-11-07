package baseball

import camp.nextstep.edu.missionutils.Console

class InOutput {
    private val _startMessage: String = "숫자 야구 게임을 시작합니다."
    private val _inputMessage: String = "숫자를 입력해주세요. : "
    private val _endMessage: String = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."

    fun inputUserData(): String {
        val inputData = Console.readLine()

        UserInputException(inputData)

        return inputData
    }

    fun inputContinueData(): String {
        val inputContinue = Console.readLine()

        ContinueInputException(inputContinue)

        return inputContinue
    }

    fun printStartMessage() {
        println(_startMessage)
    }

    fun printInputMessage() {
        print(_inputMessage)
    }

    fun printGameResult(result: String) {
        println(result)
    }

    fun printEndMessage() {
        println(_endMessage)
    }
}