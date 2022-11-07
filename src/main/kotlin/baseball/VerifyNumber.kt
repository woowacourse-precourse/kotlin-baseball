package baseball

import baseball.VerifyNumber.Companion.BALL
import baseball.VerifyNumber.Companion.NOTHING
import baseball.VerifyNumber.Companion.STRIKE

class VerifyNumber {
    fun verify(strikeCount: Int, ballCount: Int): Boolean {
        return verifyNumber(strikeCount, ballCount)
    }

    companion object {
        const val BALL = "볼"
        const val STRIKE = "스트라이크"
        const val NOTHING = "낫싱"
        const val FINISH_GAME = "게임 종료"
        const val RESTART_COMMAND = "1"
        const val FINISH_COMMAND = "2"
    }
}

private fun verifyNumber(strikeCount: Int, ballCount: Int): Boolean {
    return if (strikeCount == 3) {
        CheckRestart().check(strikeCount)
        true
    } else {
        showResultMessage(strikeCount, ballCount)
        false
    }
}

private fun showResultMessage(strikeCount: Int, ballCount: Int) {
    return with(StringBuilder()) {
        if (ballCount != 0) {
            append("${ballCount}${BALL} ")
        }
        if (strikeCount != 0) {
            append("${strikeCount}${STRIKE}")
        }
        if (isEmpty()) {
            append(NOTHING)
        }
        makeMessage(this)
    }
}

private fun makeMessage(sb: StringBuilder) {
    println(sb.toString())
}
