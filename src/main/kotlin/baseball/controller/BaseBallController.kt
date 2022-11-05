package baseball.controller

import baseball.Constants
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
            if (!isNumberException(computerNumbers)) {
                throw IllegalArgumentException()
            }
            progressGame(computerNumbers)
            OutputView().printGameOver()
        } while (!exitGame())
    }

    fun progressGame(computerNumbers: List<Int>) {
        do {
            OutputView().printInputNumber()
            val playerNumbers = PlayerNumber().inputPlayerNumber()
            if (!isNumberException(playerNumbers)) {
                throw IllegalArgumentException()
            }
            val baseBall = BaseBall(computerNumbers, playerNumbers)
            val strike = baseBall.getStrikeCount()
            val ball = baseBall.getBallCount()
            OutputView().printResult(ball, strike)
        } while (!isThreeStrike(strike))
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

    fun isThreeStrike(strike: Int): Boolean {
        return strike == Constants.NUMBER_LENGTH
    }

    fun isNumberException(number: List<Int>): Boolean {
        return number.size == Constants.NUMBER_LENGTH && isOneToNine(number) && isNotDuplicate(number)
    }

    fun isOneToNine(number: List<Int>): Boolean {
        return number.all { num -> num >= Constants.MIN_NUMBER && num <= Constants.MAX_NUMBER }
    }

    fun isNotDuplicate(number: List<Int>): Boolean {
        return number.size == number.distinct().size
    }
}