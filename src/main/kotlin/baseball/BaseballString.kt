package baseball

enum class BaseballString(val string: String) {
    START("숫자 야구 게임을 시작합니다.") {
        override fun print(strike: Int, ball: Int) = println(string)
    },
    INPUT("숫자를 입력해주세요 : ") {
        override fun print(strike: Int, ball: Int) = print(string)
    },
    BALL("볼") {
        override fun print(strike: Int, ball: Int) = println("$ball$string")
    },
    STRIKE("스트라이크") {
        override fun print(strike: Int, ball: Int) = println("$strike$string")
    },
    BALL_AND_STRIKE("") {
        override fun print(strike: Int, ball: Int) = println("$ball${BALL.string} $strike${STRIKE.string}")
    },
    NOTHING("낫싱") {
        override fun print(strike: Int, ball: Int) = println(string)
    },
    SUCCESS("${BaseballSetting.DIGIT_NUMBER.number}개의 숫자를 모두 맞히셨습니다! 게임 종료") {
        override fun print(strike: Int, ball: Int) = println(string)
    },
    RESTART_OR_QUIT("게임을 새로 시작하려면 ${BaseballSetting.RESTART.number}, 종료하려면 ${BaseballSetting.QUIT.number}를 입력하세요.") {
        override fun print(strike: Int, ball: Int) = println(string)
    },
    ILLEGAL_ARGUMENT("잘못된 값을 입력하여 게임을 종료합니다.") {
        override fun print(strike: Int, ball: Int) = println(string)
    };

    abstract fun print(strike: Int = 0, ball: Int = 0)


}