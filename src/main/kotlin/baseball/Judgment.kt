package baseball

class Judgment {

    fun countStrike(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var strikeCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] == number) strikeCount++
        }
        if (strikeCount == INITIALIZE_COUNT) return ""
        return strikeCount.toString() + STRIKE
    }

    fun countBall(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var ballCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] != number && createNumbers.contains(number)) ballCount++
        }
        if (ballCount == INITIALIZE_COUNT) return ""
        return ballCount.toString() + BALL
    }

    companion object {
        const val INITIALIZE_COUNT = 0
        const val STRIKE = "스트라이크"
        const val BALL = "볼"
    }

}