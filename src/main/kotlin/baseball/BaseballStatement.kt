package baseball

object BaseballStatement {
     fun printResult(strike: Int, ball: Int) {
        when {
            ball == 0 && strike == 0 -> BaseballString.NOTHING.print()
            ball != 0 && strike == 0 -> BaseballString.BALL.print(ball = ball)
            ball == 0 && strike != 0 -> BaseballString.STRIKE.print(strike = strike)
            else -> BaseballString.BALL_AND_STRIKE.print(ball = ball, strike = strike)
        }
    }

    fun printStart() = BaseballString.START.print()

    fun printInput() = BaseballString.INPUT.print()

    fun printSuccess() = BaseballString.SUCCESS.print()

    fun printQuit() = BaseballString.QUIT.print()

    fun printIllegalArgument() = BaseballString.ILLEGAL_ARGUMENT.print()

    fun printRestartOrQuit() = BaseballString.RESTART_OR_QUIT.print()
}