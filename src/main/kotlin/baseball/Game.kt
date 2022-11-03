package baseball

class Game {
    private val computer = Computer()
    private val user = User()

    fun start() {
        computer.generateAnswer()
        do {
            val userGuess = user.getGuessInput()
        } while (computer.compareGuessAndAnswer(userGuess))
    }
}