package baseball.game

class BaseballGame private constructor(
    private val readComputerNumber: () -> String,
    private val readUserNumber: () -> String,
    private val readFinishCode: () -> String,
) {

    fun play() {
        do {
            Message.showStartGame()

            startGame(
                ExceptionHandler.checkNumberFormat(readComputerNumber())
            )

        } while (Message.requestRestartGame(readFinishCode))

        Message.showFinishGame()
    }

    private fun startGame(computerNumber: String) {
        do {
            val userNumber = Message.requestUserNumber(readUserNumber)

            val (ball, strike) = compare(computerNumber, userNumber)

            Message.showHint(ball, strike)

        } while (strike < 3)
    }

    private fun compare(computer: String, user: String): Pair<Int, Int> {
        TODO()
    }

    class Builder {

        private lateinit var readComputerNumber: () -> String
        private lateinit var readUserNumber: () -> String
        private lateinit var readFinishCode: () -> String

        fun onStart(readComputerNumber: () -> String) = apply {
            this.readComputerNumber = readComputerNumber
        }

        fun onProgress(readUserNumber: () -> String) = apply {
            this.readUserNumber = readUserNumber
        }

        fun onFinish(readFinishCode: () -> String) = apply {
            this.readFinishCode = readFinishCode
        }

        fun build(): BaseballGame {
            return BaseballGame(readComputerNumber, readUserNumber, readFinishCode)
        }
    }
}