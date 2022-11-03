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
            printInputMessage()

            player.enterNumber()

        } while (isActiveState)
    }

    private fun printInputMessage() = print(INPUT_MESSAGE)


    override fun end() {
        TODO("Not yet implemented")
    }
}