package baseball

import utils.Constants

class Display {

    fun printBallNStrike(hint: Hint) {
        if (hint.strikeNum == 0 && hint.ballNum == 0)
            print("낫싱")
        else {
            if (hint.ballNum > 0)
                print("${hint.ballNum}볼 ")
            if (hint.strikeNum > 0)
                print("${hint.strikeNum}스트라이크")
        }
        println()
    }

    fun printGameOver() {
        println(Constants.GAME_OVER_MESSAGE)
        println(Constants.ASK_GAME_RESTART_MESSAGE)
    }

    fun printRequireInputNumber() {
        print(Constants.INPUT_PLAYER_MESSAGE)
    }
}