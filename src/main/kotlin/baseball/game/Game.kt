package baseball.game

import baseball.computer.Computer
import baseball.player.Player
import baseball.validator.InputValidator

class Game(
    private val computer: Computer,
    private val player: Player,
    private val inputValidator: InputValidator
): GameService {

    private val numberOfComputer = computer.getNumberOfComputer()
    private var gameState = GAME_ACTIVE_STATE
    private var isActiveState =
        gameState == GAME_ACTIVE_STATE

    override fun play() {
        println(START_GAME_MESSAGE)

        do {
            print(INPUT_MESSAGE)
            val numberOfPlayer = player.enterNumber()
            inputValidator.checkInput(input = numberOfPlayer)

        } while (isActiveState)
    }

    private fun printMessage(message: String) { print(message) }


    override fun end() {
        TODO("Not yet implemented")
    }
}