package baseball.game

import baseball.common.MAX_NUMBER_SIZE
import baseball.computer.Computer
import baseball.game.ballstate.BallState
import baseball.player.Player
import baseball.game.validator.InputValidator

class Game(
    private val computer: Computer,
    private val player: Player,
): GameService {

    private var gameStateCode = GAME_ACTIVE_CODE
    private val numberOfComputer: String = computer.numberOfComputer
    private val ballStates = mutableListOf(BallState.OUT, BallState.OUT, BallState.OUT)
    private val inputValidator = InputValidator()

    override fun start() {
        printMessage(message = START_GAME_MESSAGE)
        println(numberOfComputer)

        do {
            printMessage(message = INPUT_MESSAGE)

            // 사용자가 숫자 입력
            val numberOfPlayer = player.enterNumber()
            inputValidator.validateGameInput(input = numberOfPlayer)

            // 볼 or 스트라이크 체크
            checkBallStrike(numberOfComputer = numberOfComputer, numberOfPlayer = numberOfPlayer)
        } while (isActiveGameState())
    }

    /** 게임이 활성화 상태인지 판단하는 함수 **/
    private fun isActiveGameState(): Boolean = gameStateCode != END_CODE

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
        val (ballCount, strikeCount, outCount) = calcBallState()

        if (outCount == ballStates.size) {
            printMessage(message = OUTPUT_NOTHING_MESSAGE)
        }
        if (strikeCount != 0 && ballCount != 0) {
            printMessage(message = OUTPUT_BALL_STRIKE_MESSAGE.format(ballCount, strikeCount))
        }
        if (strikeCount != 0 && ballCount == 0) {
            printMessage(message = OUTPUT_STRIKE_MESSAGE.format(strikeCount))
        }
        if (strikeCount == 0 && ballCount != 0) {
            printMessage(OUTPUT_BALL_MESSAGE.format(ballCount))
        }
    }

    private fun calcBallState(): Triple<Int, Int, Int> {
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
        return Triple(ballCount, strikeCount, outCount)
    }

    /** 게임 성공 후의 일을 처리하는 함수 **/
    private fun successGame() {
        printMessage(message = SUCCESS_GAME_MESSAGE.format(MAX_NUMBER_SIZE)) // 숫자를 모두 맞혔음을 출력한다.
        askContinueGame()
    }

    /** 게임을 계속 진행할 지 여부를 묻는 함수 **/
    private fun askContinueGame() {
        printMessage(message = CONTINUE_GAME_MESSAGE) // 재시작 및 종료 여부를 묻는다.

        val endNumber = player.enterNumber()
        inputValidator.validateEndInput(input = endNumber)

        gameStateCode = endNumber.toInt()
        restartOrEndGame()
    }

    private fun restartOrEndGame() {
        when (gameStateCode) {
            RESTART_CODE -> restart()
            END_CODE -> end()
        }
    }

    private fun printMessage(message: String) { print(message) }

    override fun restart() {
        computer.recreateRandomNumber()
        println(numberOfComputer)
    }

    override fun end() {
        printMessage(message = END_GAME_MESSAGE)
        return
    }

}