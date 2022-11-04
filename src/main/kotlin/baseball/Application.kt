package baseball

import baseball.computer.Computer
import baseball.game.Game
import baseball.player.Player
import baseball.validator.InputValidator


fun main() {
    val computer = Computer()
    val player = Player()
    val inputValidator = InputValidator()

    val baseballGame = Game(computer = computer, player = player, inputValidator = inputValidator)
    baseballGame.play()
}
