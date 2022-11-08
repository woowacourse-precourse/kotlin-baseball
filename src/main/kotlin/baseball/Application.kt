package baseball

import baseball.controller.Referee
import baseball.utils.Validator
import baseball.view.Player

fun main() {
    val player = Player(validator = Validator)
    val referee = Referee(player)
    referee.startGame()
}