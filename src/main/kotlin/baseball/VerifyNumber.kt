package baseball

class VerifyNumber {
    fun verify(strikeCount: Int, ballCount: Int): Boolean {
        return verifyNumber(strikeCount, ballCount)
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
            append("${ballCount}${PrintText.BALL} ")
        }
        if (strikeCount != 0) {
            append("${strikeCount}${PrintText.STRIKE}")
        }
        if (isEmpty()) {
            append(PrintText.NOTHING)
        }
        makeMessage(this)
    }
}

private fun makeMessage(sb: StringBuilder) {
    println(sb.toString())
}
