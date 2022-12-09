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
        restartGame()
    }

    private fun gameStart(){
        outputView.gameStart()
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        var gameLoop = true
        while (gameLoop) {
            outputView.inputNumbers()
            val inputNumbers = inputView.inputBaseballNumbers()
            outputView.judgementResult(judgment.getJudgementResult(inputNumbers, createNumbers))
            gameLoop = !judgment.isThreeStrike(inputNumbers, createNumbers)
        }
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