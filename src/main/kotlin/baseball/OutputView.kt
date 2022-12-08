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

     fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        var gameLoop = true
        while (gameLoop) {
            println(OutputMessage.INPUT_NUMBERS.message)
            val inputNumbers = inputView.inputBaseballNumbers()
            judgementResult(inputNumbers, createNumbers)
            gameLoop = !isThreeStrike(inputNumbers, createNumbers)
        }
    }

     fun restartGame() {
        println(OutputMessage.QUESTION_RETRY.message)
        val restartNumber = inputView.inputRestartNumber()
        if (restartNumber == RESTART_NUMBER) baseballGame()
    }

    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Boolean {
        if (judgment.countStrike(inputNumbers, createNumbers) == MAX_COUNT) {
            println(OutputMessage.THREE_STRIKE.message)
            return true
        }
        return false
    }


    fun judgementResult(inputNumbers: List<Int>, createNumbers: List<Int>) {
        val ball = judgment.countBall(inputNumbers, createNumbers)
        val strike = judgment.countStrike(inputNumbers, createNumbers)
        var compareResult = INITIAL_COMPARE_RESULT
        if (strike + ball == NO_COUNT) compareResult = NOTHING
        if (ball != NO_COUNT) compareResult += "$ball$BALL_TEXT"
        if (strike != NO_COUNT) compareResult += "$strike$STRIKE_TEXT"
        println(compareResult)
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