package baseball.game

import baseball.game.service.Game
import baseball.model.AnswerBoard
import baseball.model.Computer
import baseball.util.*
import baseball.view.User

class Baseball(
    private val answerBoard: AnswerBoard,
    private val user: User,
    private val computer: Computer,
) : Game {
    private var gameState = PLAYING
    private var computerNumber = computer.createComputerNumber()

    override fun play() {
        println(START_MESSAGE)
        process()
    }

    override fun process() {
        do {
            val userInput = user.createNumber()
            answerBoard.createResult(
                computerInput = computerNumber,
                userInput = userInput
            )
            println(answerBoard.printResult())
            finish()
        } while (isPlaying())
    }

    // 종료 메시지
    override fun quit() {
        gameState = QUIT
    }
    // 다시 시작
    override fun retry() {
        computerNumber = computer.createComputerNumber()
        answerBoard.clearState()
    }

    // 종료 상태 1이 아닐 때 까지 반복
    private fun isPlaying(): Boolean = gameState != QUIT

    private fun finishMessage() = println(FINISH_MESSAGE + "\n" + SELECT_QUIT_RETRY_MESSAGE)
    
    private fun finish() {
        if (answerBoard.isThreeStrike()) {
            finishMessage()
            when (readLine()) {
                RETRY_COMMAND -> retry()
                QUIT_COMMAND -> quit()
            }
        }
    }
    
}

