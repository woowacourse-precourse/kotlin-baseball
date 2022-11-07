package baseball.gameservice

/** ball과 strike의 개수를 세어주는 class **/
object BallStrikeCounter {
    fun calcStrikeCount(computerNumbers: List<Int>, userNumbers: List<Int>): Int {
        var strikeCount = 0

        userNumbers.forEachIndexed { index, eachNum ->
            if (computerNumbers[index] == eachNum) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun calcBallCount(computerNumbers: List<Int>, userNumbers: List<Int>): Int {
        var ballCount = 0

        userNumbers.forEachIndexed { userNumberIndex, userNum ->
            ballCount += computerNumbers
                .filterIndexed { computerNumberIndex, _ -> computerNumberIndex != userNumberIndex }
                .filter { computerNumber -> computerNumber == userNum }.size
        }
        return ballCount
    }
}