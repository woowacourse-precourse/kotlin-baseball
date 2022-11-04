package baseball.game

import baseball.computer.Computer
import baseball.game.ballstate.BallState
import baseball.player.Player
import baseball.game.validator.InputValidator

class Game(
    private val computer: Computer,
    private val player: Player,
): GameService {

    private var gameState = GAME_ACTIVE_STATE
    private var isActiveState =
        gameState == GAME_ACTIVE_STATE

    private val numberOfComputer: String = computer.numberOfComputer
    private val ballStates = mutableListOf(BallState.OUT, BallState.OUT, BallState.OUT)
    private val inputValidator = InputValidator()

    override fun play() {
        println(START_GAME_MESSAGE)
        println(numberOfComputer)

        do {
            print(INPUT_MESSAGE)

            val numberOfPlayer = player.enterNumber()
            inputValidator.validateInput(input = numberOfPlayer)

            checkBallStrike(numberOfComputer = numberOfComputer, numberOfPlayer = numberOfPlayer)

        } while (isActiveState)
    }

    private fun checkBallStrike(numberOfComputer: String, numberOfPlayer: String) {

        numberOfComputer.forEachIndexed { cIdx, computerNum ->
            if (computerNum == numberOfPlayer[cIdx]) { // Strike
                ballStates[cIdx] = BallState.STRIKE
            }
            else if (numberOfPlayer.contains(computerNum)) { // Ball
                ballStates[cIdx] = BallState.BALL
            }
            else {
                ballStates[cIdx] = BallState.OUT
            }
        }

        if (ballStates.all { ballState -> ballState == BallState.STRIKE }) {
            successGame()
        }
        else {
            printBallState()
        }
    }

    private fun printBallState() {
        var ballCount = 0
        var strikeCount = 0
        var outCount = 0

        ballStates.forEach { ballState ->
            when (ballState) {
                BallState.BALL -> ballCount++
                BallState.STRIKE -> strikeCount++
                BallState.OUT -> outCount++
            }
        }

        if (outCount == ballStates.size) {
            println(OUTPUT_NOTHING_MESSAGE)
        }
        if (strikeCount != 0 && ballCount != 0) {
            println(OUTPUT_BALL_STRIKE_MESSAGE.format(ballCount, strikeCount))
        }
        if (strikeCount != 0 && ballCount == 0) {
            println(OUTPUT_STRIKE_MESSAGE.format(strikeCount))
        }
        if (strikeCount == 0 && ballCount != 0) {
            println(OUTPUT_BALL_MESSAGE.format(ballCount))
        }
    }

    private fun successGame() {
        println(SUCCESS_GAME_MESSAGE)
        println(END_GAME_MESSAGE)
    }

    private fun printMessage(message: String) { print(message) }

    override fun end() {
        TODO("Not yet implemented")
    }

}