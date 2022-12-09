package baseball.model

class Judgment {

    fun countStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Int {
        var strikeCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] == number) strikeCount++
        }
        return strikeCount
    }

    fun countBall(inputNumbers: List<Int>, createNumbers: List<Int>): Int {
        var ballCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] != number && createNumbers.contains(number)) ballCount++
        }
        return ballCount
    }

    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Boolean =
        countStrike(inputNumbers, createNumbers) == MAX_COUNT

    fun getJudgementResult(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        val ball = countBall(inputNumbers, createNumbers)
        val strike = countStrike(inputNumbers, createNumbers)
        var compareResult = INITIAL_COMPARE_RESULT
        if (strike + ball == NO_COUNT) compareResult = NOTHING
        if (ball != NO_COUNT) compareResult += "$ball${BALL_TEXT}"
        if (strike != NO_COUNT) compareResult += "$strike${STRIKE_TEXT}"
        return compareResult
    }


    companion object {
        const val INITIALIZE_COUNT = 0
        const val NOTHING = "낫싱"
        const val INITIAL_COMPARE_RESULT = ""
        const val BALL_TEXT = "볼 "
        const val STRIKE_TEXT = "스트라이크"
        const val NO_COUNT = 0
        const val MAX_COUNT = 3
    }
}