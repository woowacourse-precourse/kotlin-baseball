package baseball

data class BallResult(
    var strikeCnt: Int = 0,
    var ballCnt: Int = 0,
) {

    fun isNothing(): Boolean = (strikeCnt == 0 && ballCnt == 0)
    fun isOut(): Boolean = (strikeCnt == 3)
    fun clear() {
        strikeCnt = 0
        ballCnt = 0
    }

    fun makeStrikeStr() = if (strikeCnt > 0) "$strikeCnt" + STRIKE_STR else ""
    fun makeBallStr() = if (ballCnt > 0) "$ballCnt" + BALL_STR else ""
    fun makeSpace() = if (strikeCnt > 0 && ballCnt > 0) " " else ""

    companion object {
        const val STRIKE_STR = "스트라이크"
        const val BALL_STR = "볼"
        const val NOTHING_STR = "낫싱"
    }

}