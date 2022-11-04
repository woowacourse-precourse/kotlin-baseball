package baseball.game

import baseball.computer.Computer
import baseball.game.ballstate.BallState
import baseball.player.Player
import baseball.game.validator.InputValidator

class Game(
    private val computer: Computer,
    private val player: Player,
): GameService, InputValidator() {

    private var gameState = GAME_ACTIVE_STATE
    private var isActiveState =
        gameState == GAME_ACTIVE_STATE

    private val numberOfComputer = computer.numberOfComputer.toString()
    private val ballStates = mutableListOf(BallState.OUT, BallState.OUT, BallState.OUT)

    override fun play() {
        println(START_GAME_MESSAGE)

        do {
            print(INPUT_MESSAGE)

            val numberOfPlayer = player.enterNumber()
            checkInputValid(input = numberOfPlayer)

            checkBallStrike(numberOfComputer = numberOfComputer, numberOfPlayer = numberOfPlayer)

        } while (isActiveState)
    }

    private fun checkBallStrike(numberOfComputer: String, numberOfPlayer: String) {

        numberOfComputer.forEachIndexed { cIdx, computerNum ->
            if (computerNum == numberOfPlayer[cIdx]) { // 스트라이크
                ballStates[cIdx] = BallState.STRIKE
            }
            else if (numberOfPlayer.contains(computerNum)) {
                ballStates[cIdx] = BallState.BALL
            }
            ballStates[cIdx] = BallState.OUT
        }
    }


    private fun printMessage(message: String) { print(message) }


    override fun end() {
        TODO("Not yet implemented")
    }
}