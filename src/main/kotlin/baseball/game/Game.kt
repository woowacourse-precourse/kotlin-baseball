package baseball.game

import baseball.computer.Computer
import baseball.player.Player

class Game(
    private val computer: Computer,
    private val player: Player
): GameService {
    override fun play() {
        start()
    }

    override fun start() {
        println(START_GAME_MESSAGE)
    }

    override fun end() {
        TODO("Not yet implemented")
    }
}