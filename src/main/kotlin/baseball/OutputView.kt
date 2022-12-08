package baseball

class OutputView {
    private val judgment: Judgment = Judgment()
    private val numberGenerator: NumberGenerator = NumberGenerator()
    private val inputView: InputView = InputView()

    init {
        println(OutputMessage.GAME_START)
        baseballGame()
        restartGame()
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        while (true) {
            println(OutputMessage.INPUT_NUMBERS)
            judgementResult(inputView.inputBaseballNumbers(), createNumbers)
            if (isThreeStrike(inputView.inputBaseballNumbers(), createNumbers)) {
                println(OutputMessage.THREE_STRIKE)
                break
            }
        }
    }

    private fun restartGame() {
        println(OutputMessage.QUESTION_RETRY)
        val restartNumber = inputView.inputRestartNumber()
        if (restartNumber == 1) baseballGame()
    }

    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>) =
        judgment.countStrike(inputNumbers, createNumbers) == 3


    fun judgementResult(inputNumbers: List<Int>, createNumbers: List<Int>) {
        val ball = judgment.countBall(inputNumbers, createNumbers)
        val strike = judgment.countStrike(inputNumbers, createNumbers)
        var compareResult = ""
        if (strike + ball == 0) compareResult = "낫싱"
        if (ball != 0) compareResult += "${ball}볼 "
        if (strike != 0) compareResult += "${strike}스트라이크"
        println(compareResult)
    }
}