package baseball

class Game {
    private val computer = Computer()
    private val user = User()

    init {
        println("숫자 야구 게임을 시작합니다.")
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
        TODO("유저 입력 받아서 true/false 리턴")
    }
}