package baseball

private const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."

class Game {
    private val computer = Computer()
    private val user = User()

    init {
        println(START_GAME_MESSAGE)
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