package baseball

import camp.nextstep.edu.missionutils.Console

private const val NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : "
private const val ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
private const val NOTHING_MESSAGE = "낫싱"
private const val BALL_MESSAGE = "볼"
private const val STRIKE_MESSAGE = "스트라이크"
private const val CORRECT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
private const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."

class UserView {
    companion object {
        fun getGuessInput(): String {
            print(NUMBER_INPUT_MESSAGE)
            return Console.readLine()
        }

        fun getRestartInput(): String {
            println(ASK_RESTART_MESSAGE)
            return Console.readLine()
        }

        fun printStrike(strikeCount: Int) {
            println("$strikeCount$STRIKE_MESSAGE")
        }

        fun printBall(ballCount: Int) {
            println("$ballCount$BALL_MESSAGE")
        }

        fun printBallAndStrike(ballCount: Int, strikeCount: Int) {
            println("$ballCount$BALL_MESSAGE $strikeCount$STRIKE_MESSAGE")
        }

        fun printNothing() {
            println(NOTHING_MESSAGE)
        }

        fun printCorrectFinishGame() {
            println(CORRECT_MESSAGE)
        }

        fun printStartGame() {
            println(START_GAME_MESSAGE)
        }
    }
}