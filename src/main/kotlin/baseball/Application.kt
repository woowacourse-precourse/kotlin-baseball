package baseball

import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException


fun main() {
    baseballGame.initGame()
    baseballGame.setOpponentNumber()

    println(baseballGame.opponentNumber)

    val input = readLine()
    input?.let { exceptionTest(it) }

    baseballGame.compareNumber(input!!)
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

    fun compareNumber(input: String) {
        for (number in opponentNumber) {
            if (input.contains(number.toString())) {
                val digit = opponentNumber.indexOf(number)

            }
        }
    }
}

fun exceptionTest(input: String) {
    val regex = "[1-9][1-9][1-9]".toRegex()
    require(input.matches(regex)) {
        throw IllegalArgumentException()
    }

    require(input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
        throw IllegalArgumentException()
    }
}
