package baseball.view

class OutputView {
    fun printBall(ball: Int) {
        print("${ball}볼")
    }

    fun printStrike(strike: Int) {
        println("${strike}스트라이크")
    }

    fun printBallStrike(ball: Int, strike: Int) {
        println("${ball}볼 ${strike}스트라이크")
    }

    fun printMessage(message: String) {
        println(message)
    }

}