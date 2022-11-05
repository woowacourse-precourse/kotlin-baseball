package baseball.game

import baseball.common.MAX_NUMBER_SIZE
import baseball.computer.Computer
import baseball.game.processor.BallStrikeProcessor
import baseball.player.Player
import baseball.game.validator.InputValidator

class Game(
    private val computer: Computer,
    private val player: Player,
): GameService {

    private val inputValidator = InputValidator()
    private val ballStrikeProcessor = BallStrikeProcessor()
    private var gameStateCode = GAME_ACTIVE_CODE

    override fun start() {
        printMessage(message = START_GAME_MESSAGE)

        do {
            printMessage(message = INPUT_MESSAGE)

            // 사용자가 숫자 입력
            val numberOfPlayer = player.enterNumber()
            inputValidator.validateGameInput(input = numberOfPlayer)

            // 볼 or 스트라이크 체크 후 결과 판단
            ballStrikeProcessor.checkBallStrike(numberOfComputer = computer.numberOfComputer, numberOfPlayer = numberOfPlayer)
            assessResult()
        } while (isActiveGameState())
    }

    /** 게임이 활성화 상태인지 판단하는 함수 **/
    private fun isActiveGameState(): Boolean = gameStateCode != END_CODE

    /** 게임 결과를 판단하는 함수 **/
    private fun assessResult() {
        if (ballStrikeProcessor.isAllStrike()) {
            successGame()
        }
        else {
            printMessage(message = ballStrikeProcessor.makeBallStateMessage())
        }
    }

    /** 게임 성공 후의 일을 처리하는 함수 **/
    private fun successGame() {
        printMessage(message = SUCCESS_GAME_MESSAGE.format(MAX_NUMBER_SIZE)) // 숫자를 모두 맞혔음을 출력한다.
        askContinueGame()
    }

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

    override fun restart() {
        computer.recreateRandomNumber()
        ballStrikeProcessor.initBallState()
    }

    override fun end() {
        printMessage(message = END_GAME_MESSAGE)
        return
    }

    private fun printMessage(message: String) { print(message) }
}