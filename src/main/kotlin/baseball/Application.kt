package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    baseballGame.initGame()
    baseballGame.setOpponentNumber()
}

object baseballGame {
    var opponentNumber = mutableListOf<Int>()
    var ballStrike = mutableListOf(0, 0)

    fun initGame() {
        opponentNumber.clear()
    }

    fun setOpponentNumber() {
        while (opponentNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!opponentNumber.contains(randomNumber)) {
                opponentNumber.add(randomNumber)
            }
        }
    }
}