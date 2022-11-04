package baseball

class Game {

    private val user = User()
    private val computer = Computer()
    private val gameManager = GameManager()
    private val exception = Exception()

    fun start() {
        computer.number = computer.generateComputerNumber()
        do {
            printEnterNumber()
            user.input = user.getInputFromKeyboard()
            exception.checkAllException(user.input)
            user.number = user.getUserNumber(user.input)
            var ball = gameManager.countBall(user.number, computer.number)
            val strike = gameManager.countStrike(user.number, computer.number)
            ball = gameManager.getFinalBallCount(ball, strike)
            printBallAndStrike(ball, strike)
        } while (!gameManager.isThreeStrike(strike))
        printThreeStrike()
        printRestartOrEnd()
        user.reStartOrEndChoice = user.getInputFromKeyboard()
        exception.throwInvalidRestartNumber(user.reStartOrEndChoice)
        reStartOrEnd(user.reStartOrEndChoice)
    }

    private fun printEnterNumber() {
        print(ENTER_NUMBER_MESSAGE)
    }

    fun printStartGame() {
        println(START_GAME_MESSAGE)
    }

    private fun printNothing(ball: Int, strike: Int) {
        if (ball == 0 && strike == 0) print(NOTHING_MESSAGE)
    }

    private fun printBall(ball: Int) {
        if (ball != 0) print("$ball" + BALL_MESSAGE)
    }

    private fun printStrike(strike: Int) {
        if (strike != 0) print("$strike" + STRIKE_MESSAGE)
    }

    private fun printRestartOrEnd() {
        println(RESTART_OR_END_MESSAGE)
    }

    private fun printBallAndStrike(ball: Int, strike: Int) {
        if (!gameManager.isThreeStrike(strike)) {
            printBall(ball)
            printStrike(strike)
            printNothing(ball, strike)
            println("")
        }
    }

    private fun printThreeStrike() {
        println(THREE_STRIKE_MESSAGE)
    }

    private fun reStartOrEnd(choice: String) {
        if (choice == RESTART) start()
    }

    companion object {
        const val RESTART = "1"
        const val START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val ENTER_NUMBER_MESSAGE = "숫자를 입력해주세요 : "
        const val THREE_STRIKE_MESSAGE = "3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
        const val NOTHING_MESSAGE = "낫싱"
        const val STRIKE_MESSAGE = "스트라이크"
        const val BALL_MESSAGE = "볼 "
    }
}