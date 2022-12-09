package baseball.controller

import baseball.model.Judgment
import baseball.model.NumberGenerator
import baseball.view.io.InputView
import baseball.view.io.OutputView

class BaseballActivity {
    private val outputView: OutputView = OutputView()
    private val inputView: InputView = InputView()
    private val judgment: Judgment = Judgment()
    private val numberGenerator = NumberGenerator()

    fun baseballGameExecute() {
        gameStart()
        baseballGame()
    }

    private fun gameStart() {
        outputView.gameStart()
    }

    private fun winGame(isWin : Boolean) {
        outputView.winGame(isWin)
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        do {
            outputView.inputNumbers()
            val inputNumbers = inputView.inputBaseballNumbers()
            outputView.judgementResult(judgment.getTotalResult(inputNumbers, createNumbers))
            winGame(judgment.isThreeStrike(inputNumbers, createNumbers))
        } while (judgment.isThreeStrike(inputNumbers, createNumbers))
        restartGame()
    }

    private fun restartGame() {
        outputView.restartGame()
        val restartNumber = inputView.inputRestartNumber()
        if (restartNumber == RESTART_NUMBER) baseballGame()
    }

    companion object {
        const val RESTART_NUMBER = 1
    }
}