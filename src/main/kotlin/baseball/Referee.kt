package baseball

class Referee() {
    fun decideGameEnd(computerNumbers: List<Int>, userNumbers: List<Int>): RefereeDecision {
        val strikeIndices: List<Int> = countStrike(computerNumbers, userNumbers)
        val ballCount: Int = countBall(computerNumbers, userNumbers, strikeIndices)
        val strikeCount = strikeIndices.size

        return RefereeDecision(ballCount, strikeCount, strikeCount == 3)
    }

    private fun countStrike(computerNumbers: List<Int>, userNumbers: List<Int>): List<Int> {
        val strikeIndex = listOf<Int>(0, 1, 2)
        return strikeIndex.filterIndexed { index, _ ->
            computerNumbers[index] == userNumbers[index]
        }
    }

    private fun countBall(computerNumbers: List<Int>, userNumbers: List<Int>, strikeIndices: List<Int>): Int {
        var ballCount = 0
        computerNumbers.forEachIndexed { index, computerNum ->
            if (strikeIndices.contains(index)) return@forEachIndexed
            if (userNumbers.contains(computerNum)) ballCount++
        }
        return ballCount
    }
}
