package baseball.view

import baseball.message.GameMessage.NOTHING

class OutputView {

    fun printBallStrike(strike: Int, ball: Int) {
        when {
            ball == 0 && strike ==0 -> println(NOTHING)
            ball > 0 && strike == 0 -> println("${ball}볼")
            ball == 0 && strike >0 -> println("${strike}스트라이크")
            ball > 0 && strike >0 -> println("${ball}볼 ${strike}스트라이크")

        }
    }

    fun printMessage(message: String) {
        print(message)
    }

}