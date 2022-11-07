package baseball

class Calculator(
    private val userInput: String,
    private val answer: String
) {

    lateinit var ballAndStrike: Pair<Int, Int>
        private set

    fun countBallAndStrike() {
        var ballCount = 0
        var strikeCount = 0

        userInput.forEachIndexed { index, userNum ->
            if (userNum != answer[index] &&
                answer.contains(userNum)
            ) ballCount++
        }

        for (idx in 0 until 3) {
            if (userInput[idx] == answer[idx]) strikeCount++
        }

        ballAndStrike = Pair(ballCount, strikeCount)
    }
}