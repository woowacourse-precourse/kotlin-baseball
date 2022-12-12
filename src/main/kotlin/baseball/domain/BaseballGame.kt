package baseball.domain

import camp.nextstep.edu.missionutils.Randoms

class BaseballGame {

    fun generateNumber(): String {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size != 3) {
            val rand = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(rand)) {
                computerNumber.add(rand)
            }
        }
        return computerNumber.joinToString("")
    }

    fun compareNumber(player: String, computer: String): Pair<Int, Int> {
        if (player.isNothing(computer)) {
            return Pair(0, 0)
        }
        return compareBallOrStrike(player, computer)
    }

    fun compareBallOrStrike(player: String, computer: String): Pair<Int, Int> {
        var ball = 0
        var strike = 0
        for ((i, num) in player.withIndex()) {
            when (num.isStrike(i, computer)) {
                true -> strike++
                false -> ball++
            }
        }
        return Pair(ball, strike)
    }

    fun String.isNothing(computer: String): Boolean {
        for (num in this) {
            if (num in computer) {
                return false
            }
        }
        return true
    }

    fun Char.isStrike(index: Int, computer: String): Boolean {
        if (this != computer[index]) {
            return false
        }
        return true
    }
}