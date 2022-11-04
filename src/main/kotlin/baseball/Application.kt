package baseball

import baseball.computer.Computer
import baseball.game.Game
import baseball.player.Player


fun main() {
    val computer = Computer()
    val player = Player()

    val baseballGame = Game(computer = computer, player = player)
    baseballGame.play()
}
