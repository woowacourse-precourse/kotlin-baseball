package baseball

class OutputView {
    private val judgment: Judgment = Judgment()
    private val numberGenerator: NumberGenerator = NumberGenerator()
    private val inputView: InputView = InputView()

    init {
        println(OutputMessage.GAME_START.message)
        baseballGame()
        restartGame()
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        var gameLoop = true
        while (gameLoop) {
            println(OutputMessage.INPUT_NUMBERS.message)
            val inputNumbers = inputView.inputBaseballNumbers()
            judgementResult(inputNumbers, createNumbers)
            gameLoop = !isThreeStrike(inputNumbers, createNumbers)
        }
    }

    private fun restartGame() {
        println(OutputMessage.QUESTION_RETRY.message)
        val restartNumber = inputView.inputRestartNumber()
        if (restartNumber == 1) baseballGame()
    }

    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Boolean {
        if (judgment.countStrike(inputNumbers, createNumbers) == 3) {
            println(OutputMessage.THREE_STRIKE.message)
            return true
        }
        return false
    }


    fun judgementResult(inputNumbers: List<Int>, createNumbers: List<Int>) {
        val ball = judgment.countBall(inputNumbers, createNumbers)
        val strike = judgment.countStrike(inputNumbers, createNumbers)
        var compareResult = INITIAL_COMPARE_RESULT
        if (strike + ball == 0) compareResult = NOTHING
        if (ball != 0) compareResult += "$ball$BALL_TEXT"
        if (strike != 0) compareResult += "$strike$STRIKE_TEXT"
        println(compareResult)
    }

    companion object {
        const val NOTHING = "낫싱"
        const val INITIAL_COMPARE_RESULT = ""
        const val BALL_TEXT = "볼 "
        const val STRIKE_TEXT = "스트라이크"
    }
}