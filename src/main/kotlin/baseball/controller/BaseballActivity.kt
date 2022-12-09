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

    private fun gameStart(){
        outputView.gameStart()
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        var gameLoop = true
        while (gameLoop) {
            outputView.inputNumbers()
            val inputNumbers = inputView.inputBaseballNumbers()
            outputView.judgementResult(getJudgementResult(inputNumbers, createNumbers))
            gameLoop = !isThreeStrike(inputNumbers, createNumbers)
        }
    }

    private fun restartGame() {
        outputView.restartGame()
        val restartNumber = inputView.inputRestartNumber()
        if (restartNumber == RESTART_NUMBER) baseballGame()
    }

    private fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Boolean {
        if (judgment.countStrike(inputNumbers, createNumbers) == MAX_COUNT) {
            outputView.winGame()
            return true
        }
        return false
    }

    private fun getJudgementResult(inputNumbers: List<Int>, createNumbers: List<Int>) : String {
        val ball = judgment.countBall(inputNumbers, createNumbers)
        val strike = judgment.countStrike(inputNumbers, createNumbers)
        var compareResult = INITIAL_COMPARE_RESULT
        if (strike + ball == NO_COUNT) compareResult = NOTHING
        if (ball != NO_COUNT) compareResult += "$ball$BALL_TEXT"
        if (strike != NO_COUNT) compareResult += "$strike$STRIKE_TEXT"
        return compareResult
    }

    companion object {
        const val NOTHING = "낫싱"
        const val INITIAL_COMPARE_RESULT = ""
        const val BALL_TEXT = "볼 "
        const val STRIKE_TEXT = "스트라이크"
        const val NO_COUNT = 0
        const val MAX_COUNT = 3
        const val RESTART_NUMBER = 1
    }
}