package baseball

class GameManager {
    fun countBall(userNumber: List<Int>, computerNumber: List<Int>): Int {
        var ball = 0
        userNumber.forEach { num ->
            if (computerNumber.contains(num)) ball++
        }
        return ball
    }

    fun countStrike(userNumber: List<Int>, computerNumber: List<Int>): Int {
        var strike = 0
        for (index in userNumber.indices) {
            if (userNumber[index] == computerNumber[index]) strike++
        }
        return strike
    }

    fun getFinalBallCount(ball: Int, strike: Int) = ball - strike

    fun isThreeStrike(strike: Int): Boolean {
        return strike == ALL_STRIKE_NUMBER
    }

    companion object {
        const val ALL_STRIKE_NUMBER = 3
    }
}