package baseball


class Game {
    private val computer = Computer()
    private val user = User()

    init {
        UserView.printStartGame()
    }

    fun start() {
        computer.generateAnswer()
        do {
            val userGuess = user.getGuessInput()
        } while (computer.compareGuessAndAnswer(userGuess))

        if (isRestart()) {
            start()
        }
    }

    private fun isRestart(): Boolean {
        val userInput = user.getRestartOrNotInput()
        if (userInput == 1) {
            return true
        }
        return false
    }
}