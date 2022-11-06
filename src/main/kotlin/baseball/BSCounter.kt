package baseball
/** ball과 strike의 개수를 세어주는 class **/
object BSCounter {
    fun calcStrikeCount(userInput: ArrayList<Int>): Int {
        var strikeCount = 0

        userInput.forEachIndexed { index, eachNum ->
            if (Computer.randomNumbers[index] == eachNum) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun calcBallCount(userInput: ArrayList<Int>): Int {
        var ballCount = 0

        userInput.forEachIndexed { userNumberIndex, userNum ->
            ballCount += Computer.randomNumbers.filterIndexed { computerNumberIndex, _ -> computerNumberIndex != userNumberIndex }
                .filter { computerNumber -> computerNumber == userNum }.size
        }
        return ballCount
    }
}