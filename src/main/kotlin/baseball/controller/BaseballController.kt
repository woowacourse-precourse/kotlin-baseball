package baseball.controller

import baseball.domain.BaseballGame
import baseball.domain.BaseballData
import baseball.domain.Referee
import baseball.view.InputView
import baseball.view.OutputView

class BaseballController {
    private val outputView = OutputView()
    private val inputView = InputView()

    fun gameStart() {
        outputView.printGameStart()
        generateComputerNumber()
        while (BaseballData.gameState) {
            outputView.printInputNumber()
            BaseballData.userNumber = inputView.inputNumber()
            printCompareResult()
        }
        printResult()
    }

    private fun generateComputerNumber() {
        val baseball = BaseballGame()
        val computerNumber = baseball.generateNumber()
        BaseballData.computerNumber = computerNumber
        println(computerNumber) // 제거
    }

    private fun printCompareResult() {
        val (ball, strike) = compareResult()
        outputView.printCompareResult(ball, strike)
        checkLastGame(ball, strike)
    }

    private fun compareResult(): Pair<Int, Int> {
        val baseballGame = BaseballGame()
        return baseballGame.compareNumber(BaseballData.userNumber, BaseballData.computerNumber)
    }

    private fun checkLastGame(ball: Int, strike: Int) {
        val referee = Referee()
        BaseballData.gameState = referee.continueGame(ball, strike)
    }

    private fun printResult() {
        outputView.printResult()
        val command = inputView.inputCommand()
        performCommand(command)
    }

    private fun performCommand(command: String) {
        when (command) {
            "1" -> {
                BaseballData.gameState = true
                gameStart()
            }

            "2" -> return
        }
    }
}