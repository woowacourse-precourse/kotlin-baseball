package baseball

class OutputView {
    private val judgment:Judgment = Judgment()

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