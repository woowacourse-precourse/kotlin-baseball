package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    baseballGame.initGame()

}

object baseballGame {
    var opponentNumber = mutableListOf<Int>()
    var ballStrike = mutableListOf(0, 0)

    fun initGame() {
        opponentNumber.clear()
    }


}