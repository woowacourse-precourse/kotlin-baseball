package baseball

class Judgment {

    fun countStrike(inputNumbers: List<Int>, createNumbers: List<Int>): String {
        var strikeCount = 0
        inputNumbers.forEachIndexed { index, number ->
            if (createNumbers[index] == number) strikeCount++
        }
        return "${strikeCount}스트라이크"
    }

}