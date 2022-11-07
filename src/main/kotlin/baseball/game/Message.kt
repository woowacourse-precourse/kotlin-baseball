package baseball.game

object Message {

    private const val RESTART_CODE = "1"
    private const val FINISH_CODE = "2"

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
        println("""
            3개의 숫자를 모두 맞히셨습니다! 게임 종료
            게임을 새로 시작하려면 $RESTART_CODE, 종료하려면 ${FINISH_CODE}를 입력하세요.
        """.trimIndent())

        return checkFinishCode(read())
    }

    fun showFinishGame() {
        println("게임 종료")
    }

    private fun checkFinishCode(code: String): Boolean {
        return when (code) {
            RESTART_CODE -> true
            FINISH_CODE -> false
            else -> ExceptionHandler.throwFinishCode(code)
        }
    }
}