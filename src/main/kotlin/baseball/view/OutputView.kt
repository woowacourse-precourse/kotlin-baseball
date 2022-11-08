package baseball.view

import baseball.domain.Game

object OutputView {
    const val THREE_STRIKE = 3
    private const val NOTHING = 0
    private const val OPENING_MENT = "숫자 야구 게임을 시작합니다."
    private const val ENDING_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

    fun printStaringMent(): Unit = print(OPENING_MENT)

    fun printResult(game: Game){
        return if (game.strike == THREE_STRIKE) {
            println("3스트라이크")
            println(ENDING_MENT)
        } else if (game.strike == NOTHING && game.ball == NOTHING) {
            println("낫싱")
        }
        else if(game.strike == NOTHING){
            println("${game.ball}볼")
        }
        else if (game.ball == NOTHING){
            println("${game.strike}스트라이크")
        }
        else {
            println("${game.ball}볼 ${game.strike}스트라이크")
        }
    }
}
