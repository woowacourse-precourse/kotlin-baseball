package baseball.controller

import baseball.Constants
import baseball.Validations
import baseball.model.BaseBall
import baseball.model.ComputerNumber
import baseball.model.PlayerNumber
import baseball.view.InputView
import baseball.view.OutputView

class BaseBallController {
    fun startGame() {
        OutputView().printGameStart()
        do {
            val computerNumbers = ComputerNumber().getRandomNumbers()
            progressGame(computerNumbers)
            OutputView().printGameOver()
        } while (!exitGame())
    }

    fun progressGame(computerNumbers: List<Int>) {
        do {
            OutputView().printInputNumber()
            val playerNumbers = PlayerNumber().inputPlayerNumber()
            val baseBall = BaseBall(computerNumbers, playerNumbers)
            val strike = baseBall.getStrikeCount()
            val ball = baseBall.getBallCount()
            OutputView().printResult(ball, strike)
        } while (!Validations.isThreeStrike(strike))
    }

    fun exitGame(): Boolean {
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