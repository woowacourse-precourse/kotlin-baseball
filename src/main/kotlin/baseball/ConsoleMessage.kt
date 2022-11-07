package baseball

class ConsoleMessage {
    companion object {
        const val START_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val INPUT_MESSAGE = "숫자를 입력해주세요 : "
        const val SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val END_OR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"
        const val BALL_MESSAGE = "볼 "
        const val STRIKE_MESSAGE = "스트라이크"
        const val NOTHING_MESSAGE = "낫싱"
    }

    fun startMessage() {
        println(START_MESSAGE)
    }

    fun inputMessage() {
        print(INPUT_MESSAGE)
    }

    fun ballMessage(ball: Int) {
        print(ball.toString() + BALL_MESSAGE)
    }

    fun strikeMessage(strike: Int) {
        println(strike.toString() + STRIKE_MESSAGE)
    }

    fun nothingMessage() {
        println(NOTHING_MESSAGE)
    }

    fun successRestartMessage() {
        println(SUCCESS_MESSAGE)
        println(END_OR_RESTART_MESSAGE)
    }

    fun printLineBreak(){
        println()
    }
}
