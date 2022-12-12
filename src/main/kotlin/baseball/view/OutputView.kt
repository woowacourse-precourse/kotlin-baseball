package baseball.view

import baseball.util.Constant.BALL
import baseball.util.Constant.GAME_RESULT
import baseball.util.Constant.GAME_START
import baseball.util.Constant.INPUT_NUMBER
import baseball.util.Constant.NOTHING
import baseball.util.Constant.STRIKE

class OutputView {
    fun printGameStart() {
        println(GAME_START)
    }

    fun printInputNumber() {
        print(INPUT_NUMBER)
    }

    fun printCompareResult(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) {
            println(NOTHING)
        } else if (ball == 0) {
            println("$strike$STRIKE")
        } else if (strike == 0) {
            println("$ball$BALL")
        } else {
            println("$ball$BALL $strike$STRIKE")
        }
    }

    fun printResult() {
        println(GAME_RESULT.trimIndent())
    }
}