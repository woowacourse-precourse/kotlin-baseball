package baseball.hint

import domain.Computer
import domain.Player

class BaseballHint(
    computer: Computer,
    player: Player
) : Hint(computer, player) {

    override fun print() {
        val (strike, ball) = provideStrikeAndBall()
        when {
            (strike != 0 && ball != 0) -> println("${ball}볼 ${strike}스트라이크")
            (strike != 0 && ball == 0) -> println("${strike}스트라이크")
            (strike == 0 && ball != 0) -> println("${ball}볼")
            (strike == 0 && ball == 0) -> println("낫싱")
        }
    }

    override fun calculate() {
        (0 until 3).forEach { index ->
            compare(index)
        }
    }

    private fun compare(index: Int) {
        when {
            computer.isEquals(index, player.find(index)) -> plusStrike()
            computer.contains(player.find(index)) -> plusBall()
        }
    }

}