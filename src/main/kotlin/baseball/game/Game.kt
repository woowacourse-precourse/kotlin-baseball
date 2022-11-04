package baseball.game

import baseball.computer.Computer
import baseball.player.Player

class Game(
    private val computer: Computer,
    private val player: Player
): GameService {

    private val numberOfComputer = computer.getNumberOfComputer()
    private var gameState = GAME_ACTIVE_STATE
    private var isActiveState =
        gameState == GAME_ACTIVE_STATE

    override fun play() {
        println(START_GAME_MESSAGE)

        do {
            print(START_GAME_MESSAGE)

            player.enterNumber()

        } while (isActiveState)
    }

    private fun print(message: String) { print(message) }


    override fun end() {
        TODO("Not yet implemented")
    }
}