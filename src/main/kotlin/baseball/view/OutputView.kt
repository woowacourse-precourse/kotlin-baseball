package baseball.view

import baseball.domain.Game

object OutputView {
    fun printStaringMent(): Unit = print("숫자 야구 게임을 시작합니다.")

    fun printResult(game: Game): Int {
        return if (game.strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            THREE_STRIKE
        } else if (game.strike == 0 && game.ball == 0) {
            println("낫싱")
            NOTHING
        } else {
            println("${game.strike} 스트라이크 ${game.ball} 볼")
            STRIKE_AND_BALL
        }
    }


    const val THREE_STRIKE = 0
    const val NOTHING = 1
    const val STRIKE_AND_BALL = 2
}
