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
        val hint = mutableListOf<String>()
            .apply {
                if (ball != 0) add("${ball}볼")
                if (strike != 0) add("${strike}스트라이크")
            }
            .joinToString(" ")
            .ifBlank { "낫싱" }

        println(hint)
    }

    fun requestRestartGame(read: () -> String): Boolean {
        TODO()
    }

    fun showFinishGame() {
        TODO()
    }
}