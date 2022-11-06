package baseball

enum class BaseballString(val string: String) {
    START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    SUCCESS("개의 숫자를 모두 맞히셨습니다! 게임 종료");

    fun restartOrQuit(restartNumber: Int, quitNumber: Int): String {
        return "게임을 새로 시작하려면 $restartNumber, 종료하려면 ${quitNumber}를 입력하세요."
    }

    fun result(strike: Int, ball: Int): String {
        return when {
            strike == 3 -> STRIKE.string
            ball == 0 && strike == 0 -> NOTHING.string
            ball != 0 && strike == 0 -> "$ball${BALL.string}"
            ball == 0 && strike != 0 -> "$strike${STRIKE.string}"
            else -> "$ball${BALL.string} $strike${STRIKE.string}"
        }
    }
}