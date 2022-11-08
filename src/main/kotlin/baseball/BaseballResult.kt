package baseball

data class BaseballResult(var ball: Int, var strike: Int){
    override fun toString(): String {
        return when {
            ball == 0 && strike == 0 -> "${BaseballString.NOTHING.string}"
            ball != 0 && strike == 0 -> "$ball${BaseballString.BALL.string}"
            ball == 0 && strike != 0 -> "$strike${BaseballString.STRIKE.string}"
            else -> "$ball${BaseballString.BALL.string} $strike${BaseballString.STRIKE.string}"
        }
    }

    operator fun plus(baseballResult: BaseballResult){
        ball += baseballResult.ball
        strike += baseballResult.strike
    }
}
