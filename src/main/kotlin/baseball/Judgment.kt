package baseball

class Judgment {

    fun countStrike(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var strikeCount = INITIALIZE_COUNT
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] == number) strikeCount++
        }
        return strikeCount.toString() + STRIKE
    }

    companion object {
        const val INITIALIZE_COUNT = 0
        const val STRIKE = "스트라이크"
    }

}