package baseball.controller

import baseball.domain.BaseballData
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController {
    var outputView = OutputView()
    var inputView = InputView()

    fun gameStart() {
        outputView.printGameStart()
        outputView.printInputNumber()
        BaseballData.userNumber = inputView.inputNumber()
    }
}