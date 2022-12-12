package baseball.controller

import baseball.domain.Baseball
import baseball.domain.BaseballData
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun gameStart() {
        outputView.printGameStart()
        generateComputerNumber()
        outputView.printInputNumber()
        BaseballData.userNumber = inputView.inputNumber()
    }

    private fun generateComputerNumber() {
        val baseball = Baseball()
        val computerNumber = baseball.generateNumber()
        BaseballData.computerNumber = computerNumber
        println(computerNumber) // 제거
    }
}