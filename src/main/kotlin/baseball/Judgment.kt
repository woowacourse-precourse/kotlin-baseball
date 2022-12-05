package baseball

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

    companion object {
        const val INITIALIZE_COUNT = 0
    }

}