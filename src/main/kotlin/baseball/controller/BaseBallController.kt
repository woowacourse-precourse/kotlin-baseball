package baseball.controller

import baseball.Constants
import baseball.Validations
import baseball.model.ComputerNumber
import baseball.model.PlayerNumber
import baseball.view.InputView
import baseball.view.OutputView

class BaseBallController {
    fun startGame() {
        OutputView().printGameStart()
        do {
            processGame(ComputerNumber().getRandomNumbers())
            OutputView().printGameOver()
        } while (!exitGame())
    }

    private fun processGame(computerNumbers: List<Int>) {
        do {
            OutputView().printInputNumber()
            val playerNumbers = PlayerNumber().inputPlayerNumber(InputView().startPlayerNumber())
            val counterController = CounterController(computerNumbers, playerNumbers)
            OutputView().printResult(counterController.ball, counterController.strike)
        } while (!Validations.isThreeStrike(counterController.strike))
    }

    private fun exitGame(): Boolean {
        val endNumber = InputView().endPlayerNumber()
        if (endNumber == Constants.RESTART) {
            return false
        }
        if (endNumber == Constants.QUIT) {
            return true
        }
        throw IllegalArgumentException()
    }
}