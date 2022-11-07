package baseball

import utils.Constants

class Display {
    fun printGameStart() {
        println(Constants.GAME_START_MESSAGE)
    }

    fun printBallNStrike(hint: Hint) {
        if (hint.strikeNum == 0 && hint.ballNum == 0)
            printNothing()
        else {
            if (hint.ballNum > 0)
                printBall(hint.ballNum)
            if (hint.strikeNum > 0)
                printStrike(hint.strikeNum)
        }
        println()
    }

    private fun printNothing() {
        print("낫싱")
    }
    private fun printBall(ballNum: Int) {
        print("${ballNum}볼 ")
    }
    private fun printStrike(strikeNum: Int) {
        print("${strikeNum}스트라이크")
    }

    fun printGameOver() {
        println(Constants.GAME_OVER_MESSAGE)
        println(Constants.ASK_GAME_RESTART_MESSAGE)
    }

    fun printRequireInputNumber() {
        print(Constants.INPUT_PLAYER_MESSAGE)
    }
}