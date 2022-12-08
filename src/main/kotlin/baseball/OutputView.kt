package baseball

class OutputView {
    private val judgment: Judgment = Judgment()
    private val numberGenerator: NumberGenerator = NumberGenerator()
    private val inputView: InputView = InputView()

    init {
        println("숫자 야구 게임을 시작합니다.")
        baseballGame()
        restartGame()
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        while (true) {
            println("숫자를 입력해주세요 : ")
            judgementResult(inputView.inputBaseballNumbers(), createNumbers)
            if (isThreeStrike(inputView.inputBaseballNumbers(), createNumbers)) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }

    private fun restartGame() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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