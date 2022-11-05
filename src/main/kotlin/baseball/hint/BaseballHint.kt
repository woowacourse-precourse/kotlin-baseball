package baseball.hint

import model.Computer
import model.Player
import utils.Constants.DIGIT_LENGTH
import utils.Constants.NO_BALL
import utils.Constants.NO_STRIKE

class BaseballHint(
    computer: Computer,
    player: Player
) : Hint(computer, player) {

    override fun print() {
        val (strike, ball) = provideStrikeAndBall()
        when {
            (strike != NO_STRIKE && ball != NO_BALL) -> println("${ball}볼 ${strike}스트라이크")
            (strike != NO_STRIKE && ball == NO_BALL) -> println("${strike}스트라이크")
            (strike == NO_STRIKE && ball != NO_BALL) -> println("${ball}볼")
            (strike == NO_STRIKE && ball == NO_BALL) -> println("낫싱")
        }
    }

    override fun calculate() {
        val startIndex = 0
        (startIndex until DIGIT_LENGTH).forEach { index ->
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