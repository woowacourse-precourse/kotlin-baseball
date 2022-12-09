package baseball.model

class Judgment {

    fun getStrikeResult(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var strikeCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] == number) strikeCount++
        }
        if (strikeCount != NO_COUNT) return strikeCount.toString() + STRIKE_TEXT
        return EMPTY_RESULT
    }

    fun getBallResult(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var ballCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] != number && createNumbers.contains(number)) ballCount++
        }
        if (ballCount != NO_COUNT) return ballCount.toString() + BALL_TEXT
        return EMPTY_RESULT
    }

    fun isThreeStrike(inputNumbers: List<Int>, createNumbers: List<Int>): Boolean =
        getStrikeResult(inputNumbers, createNumbers) == THREE_STRIKE

    fun getTotalResult(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        val judgmentResult =
            listOf(getBallResult(inputNumbers, createNumbers), getStrikeResult(inputNumbers, createNumbers))
                .filter { result -> result != EMPTY_RESULT }
                .joinToString(SPACE)
        if (judgmentResult == EMPTY_RESULT) return NOTHING
        return judgmentResult
    }

    companion object {
        const val INITIALIZE_COUNT = 0
        const val NOTHING = "낫싱"
        const val EMPTY_RESULT = ""
        const val SPACE = " "
        const val BALL_TEXT = "볼"
        const val STRIKE_TEXT = "스트라이크"
        const val NO_COUNT = 0
        const val THREE_STRIKE = "3스트라이크"
    }
}