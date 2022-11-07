package baseball.game

object Message {

    fun showStartGame() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun requestUserNumber(read: () -> String): String {
        print("숫자를 입력해주세요 : ")

        return ExceptionHandler.checkNumberFormat(read())
    }

    fun showHint(ball: Int, strike: Int) {
        TODO()
    }

    fun requestRestartGame(read: () -> String): Boolean {
        TODO()
    }

    fun showFinishGame() {
        TODO()
    }
}