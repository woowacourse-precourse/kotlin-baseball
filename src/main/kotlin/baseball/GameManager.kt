package baseball

class GameManager {

    fun printStartGame() {
        println(START_GAME_MESSAGE)
    }

    fun printEnterNumber() {
        print(ENTER_NUMBER_MESSAGE)
    }

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

    fun printThreeStrike() {
        println(THREE_STRIKE_MESSAGE)
    }

    fun printNothing(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) print(NOTHING_MESSAGE)
    }

    fun printBall(ball: Int) {
        if (ball != 0) print("$ball" + BALL_MESSAGE)
    }

    fun printStrike(strike: Int) {
        if (strike != 0) print("$strike" + STRIKE_MESSAGE)
    }

    companion object {
        const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
        const val THREE_STRIKE_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임종료"
        const val NOTHING_MESSAGE = "낫싱"
        const val STRIKE_MESSAGE = "스트라이크"
        const val BALL_MESSAGE = "볼 "
        const val ALL_STRIKE_NUMBER = 3
    }
}