package baseball

class OutputView {
    private val judgment:Judgment = Judgment()
    private val numberGenerator : NumberGenerator = NumberGenerator()
    private val inputView: InputView = InputView()

    init {
        println("숫자 야구 게임을 시작합니다")
    }

    private fun baseballGame() {
        val createNumbers = numberGenerator.createBaseballNumbers()
        while (true) {
            val inputNumbers = inputView.inputBaseballNumbers()
            judgementResult(inputNumbers, createNumbers)
            if (isThreeStrike(inputNumbers, createNumbers)) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }
    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>) =
        judgment.countStrike(inputNumbers, createNumbers) == 3


    fun judgementResult(inputNumbers: List<Int>, createNumbers: List<Int>) {
        val ball = judgment.countBall(inputNumbers, createNumbers)
        val strike = judgment.countStrike(inputNumbers, createNumbers)
        var compareResult = ""
        if(strike+ball == 0) compareResult = "낫씽"
        if(ball != 0) compareResult += "${ball}볼 "
        if(strike != 0)  compareResult += "${strike}스트라이크"
        println(compareResult)
    }
}